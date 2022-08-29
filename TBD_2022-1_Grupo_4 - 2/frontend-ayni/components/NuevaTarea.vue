<template>
  <div class="wrapper fadeInDown scrollDiv" style="background-color: #4F3185">
  <div id="formContent"  style="background-color: #169691">
    
    <!-- Tabs Titles -->

    <div>
        <h1> Creacion nueva tarea</h1> 
    </div>

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="../store/ayni-logo.png" id="icon" alt="User Icon" />
    </div>

    <!-- Mapa-->
    <div id="mapid"></div>
    <!-- Login Form -->
    <form>
      <input type="text" id="Nombre de la Tarea" class="fadeIn second" name="Nombre de la Tarea" placeholder="Nombre de la Tarea">
      <input type="text" id="Descripcion" class="fadeIn second" name="Descripcion" placeholder="Descripcion">
      <input type="text" id="Fecha" class="fadeIn third" name="Fecha" placeholder="Fecha">
    </form>

    <!-- Botones -->

    <div class = "contenedorDos" >
        <div>
            <a href="./SelectVolTarea">
            <button type="button" class="btn btn-primary btn-lg">Registrar</button>
            </a>
        </div>
    </div>
  </div>

</div>
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
        async getPoints(map){
            try{
                //Se llama al servicio para obtener los puntos de la tarea
                let response = await axios.get('/tarea');
                let dataPoints = response.data;
                //Se itera por cada punto
                dataPoints.forEach(point => {
                    //Se crea el marcador para cada punto
                    let p = [point.longitude, point.latitude]
                    let marker = L.marker(p, {icon: myIcon})
                    .bindPopup(point.nombre)

                    //Se agrega a la lista
                    this.points.push(marker);
                });

                //Los puntos de la lista se agregan al mapa
                this.points.forEach(p=>{
                    p.addTo(map);
                })
            } catch (error) {
                console.log(error);
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
            maxZoom: 5
        }).addTo(this.mymap);

        //Evento click obtiene lat y long actual
        this.mymap.on('click', function(e) {
            _this.latitude = e.latlng.lat;
            _this.longitude =e.latlng.lng;
        });

        //Se agregan los puntos mediante llamada al servicio
        this.getPoints(this.mymap);
    },
    created:function(){
        this.getData();
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

