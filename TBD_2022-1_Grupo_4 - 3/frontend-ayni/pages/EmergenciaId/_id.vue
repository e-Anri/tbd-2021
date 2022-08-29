<template>
<body>
    <Navbar/>
    <div class="wrapper fadeInDown scrollDiv col-sm" style="background-color: #4f3185">
        <!-- TWO CONTAINER -->
        <div class="container">
            <div class="row">
                <div class="col-sm">
                    <div class="card" style="background-color: #169691">
                        <div class="card-body">
                            <h5 class="card-title">Emergencia</h5>
                            <p class="card-text">
                                <div class="form-group">        
                                    <div v-for="(item,index) in items_emergencia" :key="index">
                                        <h1>{{item.nombre}} id: {{param}}</h1>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm">
                                        <div id="mapid"></div>
                                    </div>
                                </div>
                                <div v-for="(item,index) in items_emergencia" :key="index">
                                        <h4>{{item.descripcion}}</h4>
                                        <!-- Coordenadas -->
                                        <p>
                                            {{item.longitude+','+item.latitude}}
                                        </p>
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
                                 <div  v-for="(item, index) in items_tarea" :key="index">
                                    <div>
                                        <h1> </h1>
                                        <a v-bind:href="'../TareaId/'+item.id">
                                        <button class="botonDos"><span>{{item.nombre}}</span></button>
                                        </a>
                                    </div>
                                </div>
                            <p class="card-text">
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> 


</body>
</template>

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
export default {
    name: 'emergenciaId',
    data:function(){
        return{
            param:this.$route.params.id,
            items_emergencia:[],
            items_tarea:[],
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
        //Se obtiene la emergencia con el id
        getEmergenciaId:function(){
            axios.get('/emergencia/getById/'+this.param)
            .then(response => {
                this.items_emergencia = response.data;
            })
            .catch(error => {
                console.log(error);
            })
        },
        //Se obtiene las tareas de la emergencia
        getTareasEmergencia:function(){
            axios.get('/tarea/getTareaByIdEmergencia/'+this.param)
            .then(response => {
                this.items_tarea = response.data;
            })
            .catch(error => {
                console.log(error);
            })
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
                let response = await axios.get('/tarea/getTareaByIdEmergencia/'+this.param);
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
            maxZoom: 10
        }).addTo(this.mymap);

        //Evento click obtiene lat y long actual
        this.mymap.on('click', function(e) {
            _this.latitude = e.latlng.lat;
            _this.longitude =e.latlng.lng;
        });

        //Se agregan los puntos mediante llamada al servicio
        this.getPoints(this.mymap);

        //Se obtiene la emergencia con el id
        axios.get('/emergencia/getById/'+this.param)
        .then(response => {
            this.items_emergencia = response.data;
        })
        .catch(error => {
            console.log(error);
        })
        //Se obtiene las tareas de la emergencia
        axios.get('/tarea/getTareaByIdEmergencia/'+this.param)
        .then(response => {
            this.items_tarea = response.data;
        })
        .catch(error => {
            console.log(error);
        })
    },
    created:function(){
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
