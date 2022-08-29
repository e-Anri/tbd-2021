<template>
<body>
  <div class="wrapper fadeInDown scrollDiv col-sm" style="background-color: #4f3185; height: 100px">
  </div>
    <!-- TWO CONTAINER -->
    <div class="container">
      <div class="row">
        <div class="col-sm">
          <div class="card" style="background-color: #169691">
            <div class="card-body">
              <h5 class="card-title">Tareas</h5>
              <select v-model="selected">
                <option disabled value="">Seleccione una región</option>
                <option v-for="(region, key) in regiones" :key="region.id" :value="region.id_region">{{region.nom_reg}}</option>  
              </select>
              <button type="button" @click="setTareasRegion(selected)">Consultar</button>
              <p class="card-text">                 
                <div class="form-group">
                    <div class="col-sm">
                        <div id="mapid"></div>
                    </div>
                </div>
              </p>
            </div>
          </div>
        </div>
        <div class="col-sm">
          <div style="padding-bottom: 10px">
              <a href="/NuevaTarea">
                <button type="button" class="btn btn-success">Nueva tarea</button>
              </a>
          </div>
          <div>
            <span>

            </span>
          </div>
          <div class="card" style="background-color:#169691">
            <div class="card-body">
              <h5 class="card-title">Tareas</h5>
                <div  v-for="(item, index) in items" :key="index">
                  <div>
                    <h1> </h1>
                      <a v-bind:href="'../TareaId/'+item.id">
                        <button class="botonTres"><span>{{item.nombre}}</span></button>
                      </a>
                  </div>
                </div>
                <p class="card-text"></p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div> 
</body>
</template>

<style>
.scrollDiv {
    height: 100vh;
    max-height: 100vh;
}
</style>

<script>
//Importaciones
import 'leaflet/dist/leaflet'; //librería leaflet
import 'leaflet/dist/leaflet.css'; //css leaflet
var icon = require('leaflet/dist/images/marker-icon.png'); //ícono de marcadores
//Se crea objeto ícono con el marcador
var LeafIcon = L.Icon.extend({
          options: {iconSize:[25, 41], iconAnchor:[12, 41], popupAnchor: [-3, -41]}
      });
var myIcon = new LeafIcon({iconUrl: icon});

//Libreria axios
import axios from 'axios';
import Navbar from './Navbar.vue';
export default {
  components: { Navbar },
    name: 'emergenciaId',
    data:function(){
        return{
            items:[],
            latitude:null, //Datos de nuevo punto
            longitude:null,
            name:'',
            points:[], //colección de puntos cargados de la BD
            message:'', 
            mymap:null, //objeto de mapa(DIV)
            selected:'',
            regiones:[],
        }
    },
    computed:{
      point(){ // función computada para representar el punto seleccionado
        if(this.latitude && this.longitude){
          let lat = this.latitude.toFixed(3);
          let lon = this.longitude.toFixed(3);
          return `(${lat}, ${lon})`;
        }else{
          return '';
        }
      }
    },
    methods:{
        //Función asíncrona para consultar los datos
          getData: async function(){
              try {
                  let response2 = await this.$axios.get("/tarea");
                  this.items = response2.data;
                  console.log(response2);
                  let response = await this.$axios.get("/region");
                  this.regiones = response.data;
                  console.log(response);
              } catch (error) {
                  console.log('error', error);
              }
          },
        clearMarkers:function(){ //eliminar marcadores
        
        this.points.forEach(p=>{
            this.mymap.removeLayer(p);
        })
        this.points = [];
        },
        async createPoint(){ //Crear un nuevo punto
          this.message = '';
          let newPoint ={
            name: this.name,
            latitude: this.latitude,
            longitude: this.longitude
          }
          
          try {
            let response = await axios.post('/tarea' ,newPoint);
            console.log('response', response.data);
            let id = response.data.id;
            this.message = `${this.name} fue creado con éxito con id: ${id}`;
            this.name = '';
            this.clearMarkers(this.mymap);
            this.getPoints(this.mymap)
          } catch (error) {
          console.log('error', error); 
          this.message = 'Ocurrió un error'
          }
        },
        async getPoints(map){
          try {
            //se llama el servicio 
            let response = await axios.get('/tarea');
            let dataPoints = response.data;
            //Se itera por los puntos
            dataPoints.forEach(point => {
              //Se crea un marcador por cada punto
              let p =[point.longitude, point.latitude]
              let marker = L.marker(p, {icon:myIcon}) //se define el ícono del marcador
              .bindPopup(point.nombre) //Se agrega un popup con el nombre
              
              //Se agrega a la lista
              this.points.push(marker);
            });
            //Los puntos de la lista se agregan al mapa
            this.points.forEach(p=>{
              p.addTo(map)
            })
          } catch (error) {
          console.log('error', error); 
          }
          
        },
        async getRegiones(){
          try{
            let response = await axios.get('/region');
            this.regiones = response.data;
            console.log(response.data); 
          } catch (error) {
            console.log('error', error); 
          }
        },
        async setTareasRegion(){
        try{
          console.log(this.selected);
          let response = await axios.get('/tarea/getTareaByIdRegion/'+this.selected);
          let dataPoints = response.data;
          console.log(response.data);
          this.items = response.data;
          this.clearMarkers(this.mymap);
          //Se itera por los puntos
          dataPoints.forEach(point => {
            //Se crea un marcador por cada punto
            let p =[point.longitude, point.latitude];
            console.log(p);
            let marker = L.marker(p, {icon:myIcon}) //se define el ícono del marcador
            .bindPopup(point.nombre) //Se agrega un popup con el nombre
            
            //Se agrega a la lista
            this.points.push(marker);
          });
          console.log(this.points);
          //Los puntos de la lista se agregan al mapa
          this.points.forEach(p=>{
            p.addTo(this.mymap)
          })
        } catch (error) {
        console.log('error', error); 
        }
      },
    },
    
      
    
    mounted:function(){
    let _this = this;
    //Se asigna el mapa al elemento con id="mapid"
     this.mymap = L.map('mapid').setView([-33.456, -70.648], 7);
    //Se definen los mapas de bits de OSM
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    	attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
    	maxZoom: 10
    }).addTo(this.mymap);
    //Evento click obtiene lat y long actual
    this.mymap.on('click', function(e) {
      _this.latitude = e.latlng.lat;
      _this.longitude =e.latlng.lng;
    });
    //Se agregan los puntos mediante llamada al servicio
    this.getPoints(this.mymap);
  },
  //Función que se ejecuta al cargar el componente
  created:function(){
    this.getData();
    this.getRegiones();
    this.getPoints(this.mymap);
  },
  
}
</script>
<style>
#mapid{
    height: 400px;
    width: 500px;
}
</style>

