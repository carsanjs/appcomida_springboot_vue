

<template>
  
  <main class="maincontenapp">
    <div class="contendor">
      <div class="contencontendor">
        <div class="divlogo">
          <img class="logo" src="../assets/Img/fasfood2.jpg" alt="" />
        </div>

        <div class="divtitulo">
          <h1 class="h1color">
            {{ primertitle
            }}<small class="smallcolor">{{ segindotitle }}</small>
          </h1>
        </div>
      </div>
      <div class="conten-lefrigth">
      <div class="text-left">
        <a href  @click.prevent="add" class="btn btn-info btn-sm"
          >Agregar Comida</a>
      </div>
      <div class="text-right">
        <a href  @click.prevent="verproductos" class="btn btn-info btn-sm"
          >Ver Comida</a>
      </div>
      <div class="text-left">
        <a href  @click.prevent="edit" class="btn btn-info btn-sm"
          >Mas Opciones</a>
      </div>
    </div>
      <table class="table mt-2">
        <tbody>
          <tr>
            <th>Codigo</th>
            <th>NombreProducto</th>
            <th>TipoProducto</th>
            <th>PrecioProducto</th>
          </tr>
     
          <tr v-if="!respuesta || respuesta.length == 0 ">
            <td colspan="7" class="text-center">no hay Comida registrada</td>
          </tr>

          <tr v-else v-for="dato in respuesta">
            <td>{{ dato.codigo }}</td>
            <td>{{ dato.nombre_producto }}</td>
            <td>{{ dato.tipo_producto }}</td>
            <td>{{ dato.precio_producto }}</td>
           </tr> 
        
        </tbody>
      </table>

 <div v-if="modal" ref="modal" class="modal fade" id="modalForm" tabindex="-1" role="dialog" aria-labelledby="modalFormLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="modalFormLabel">{{modal.title}}</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>

      <form v-on:submit.prevent="save">
            <div class="modal-body">
              <div class="form-group row">
                <label class="col-form-label col-3">Codigo</label>
                <div class="col-5 colfive-modif">
                  <input
                    type="text"
                    v-model="codigo"
                    name="codigo"
                    id="codigo"
                    class="form-control"
                    placeholder="Codigo."
                    required
                  />
                 
                   <!-- v-bind:on-click="verproductos"-->
                </div>
              </div>
              <div class="form-group row">
                <label class="col-form-label col-3">Nombre</label>
                <div class="col-5">
                  <input
                    type="text"
                    v-model="nombre_producto"
                    name="nombre_producto"
                    id="nombre_producto"
                    class="form-control"
                    placeholder="Nombre producto."
                    required
                  />
                </div>
              </div>
              <div class="form-group row">
                <label class="col-form-label col-3">Tipo</label>
                <div class="col-5">
                  <input
                    type="text"
                    v-model="tipo_producto"
                    id="tipo_producto"
                    name="tipo_producto"
                    class="form-control"
                    placeholder="Tipo producto"
                    required
                  />
                </div>
              </div>
              <div class="form-group row">
                <label class="col-form-label col-3">Precio</label>
                <div class="col-5">
                  <input
                    type="text"
                    v-model="precio_producto"
                    name="precio_producto"
                    id="precio_producto"
                    class="form-control"
                    placeholder="Valor producto"
                    required
                  />
                </div>
              </div>
            </div>
            <div class="modal-footer">
              <!-- data-dismiss="modal" -->    
              <!-- <button type="button" class="btn btn-secondary">Eliminar</button> -->
              <button type="submit" class="btn btn-primary">Agregar</button>
            </div>
          </form>

          <!-- <div v-show="">
            <p>holamundo</p>
          </div> -->

          
    </div>
  </div>
</div>
<!-- -------------------------comienzo de modal editar------------ -->
<div v-if="modaledit" ref="modaledit" class="modal fade" id="modalForm" tabindex="-1" role="dialog" aria-labelledby="modalFormLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="modalFormLabel">{{modaledit.title}}</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>

      <form v-on:submit.prevent="ActualizarProducto">
            <div class="modal-body">
              <div class="form-group row">
                <label class="col-form-label col-3">Codigo</label>
                <div class="col-5 colfive-modif">
                  <input
                    type="text"
                    v-model="codigo"
                    
                    name="codigo"
                    id="codigo"
                    class="form-control"
                    placeholder="Codigo."
                   
                  />
                  <input
                    name="search"
                    type="button"
                    class="form-control Buscar"
                    value="Buscar"
                    @click="BuscarProductoId"
             
                  />
                  <!-- <input
                    name="search"
                    type="button"
                    class="form-control Buscar"
                    value="Buscar"
             
                  /> -->
                   <!-- v-bind:on-click="verproductos"-->
                </div>
              </div>
              <div class="form-group row">
                <label class="col-form-label col-3">Nombre</label>
                <div class="col-5">
                  <input
                    type="text"
                    v-model="respuesta.nombre_producto"
                    name="nombre_producto"
                    id="nombre_producto"
                    class="form-control"
                    placeholder="Nombre producto."
                    required
                  />
                </div>
              </div>
              <div class="form-group row">
                <label class="col-form-label col-3">Tipo</label>
                <div class="col-5">
                  <input
                    type="text"
                    v-model="respuesta.tipo_producto"
                    id="tipo_producto"
                    name="tipo_producto"
                    class="form-control"
                    placeholder="Tipo producto"
                    required
                  />
                </div>
              </div>
              <div class="form-group row">
                <label class="col-form-label col-3">Precio</label>
                <div class="col-5">
                  <input
                    type="text"
                    v-model="respuesta.precio_producto"
                    name="precio_producto"
                    id="precio_producto"
                    class="form-control"
                    placeholder="Valor producto"
                    required
                  />
                </div>
              </div>
            </div>
            <div class="modal-footer">

              <button type="submit" class="btn btn-secondary">
                Actualizar
              </button>
              <button type="button" class="btn btn-secondary" @click="eliminarproducto">
              Eliminar
              </button>
            </div>
          </form>
    </div>
  </div>

</div>
    </div>
  </main>

  
</template>


<style scoped>
* {
  box-sizing: border-box;
}

.bodysession {
  height: 1000px;
}

.idapp {
  background-image: url("../img/hambur3.jpg");
  background-repeat: no-repeat;
  background-position: center;
  height: 500px;
}

div .contencontendor .divlogo {
  margin: 0 auto;
  width: 50%;
}

/* div .divtitulo{
    font-size: 26px;
    margin: 0 auto;
} */

div .divtitulo h1 {
  font-weight: 500;
  margin: 0;
  font-size: 50px;
  text-align: center;
  color: orange;
}

div h1 .smallcolor {
  color: #b8bbb9;
}

img.logo {
  width: 30%;
  height: 200px;
  position: relative;
  border-radius: 10px;
  border: none;
  left: 225px;
}

/* /////////////////////////////////////////////77 */

div main.maincontenregistro {
  border-radius: 10px;
  background-color: #ffffff;
  margin: 0 auto;
  width: 40%;
  height: 360px;
}
main div h1 {
  font-size: 28px;
  color: rgb(29, 28, 28);
}
.divmaincontent {
  position: absolute;
  /* background: red; */
  width: 80%;
  height: 400px;
  left: 90px;
  top: 420px;
}

.contenidoinputs {
  width: 80%;
  margin: 0 auto;
}

.divinputs {
  padding: 0.3rem;
}

.contenidoinputs .divinputs input {
  border: none;
  width: 100%;

  border-bottom: 1px solid;
  height: 30px;
}

.contenedorbutton {
  position: relative;
  top: 100px;
  width: 70%;
  height: 40px;
  margin: 0 auto;
}

/* button#buttonid{
  width: 30%;
  height: 40px;
  font-size: 24px;
  color: #ffffff;
  border: none;
  border-radius: 40px;
  background-color: #da3636;
} */

.contencuentaoff {
  position: relative;
  top: 110px;
}

.cuentaoff {
  font-size: 16px;
  font-family: Verdana, Geneva, Tahoma, sans-serif;
  width: 80%;
  padding-left: 20px;
  margin: 0 auto;
}

.cuentaoff a {
  color: rgb(29, 28, 28);
  text-decoration: none;
}

.conttitlewelcome {
  text-align: center;
}

/* //////////////////////////////////777MEDIAA QUERYS */
@media screen and (min-width: 268px) and (max-width: 429px) {
  .divlogo img.logo {
    width: 100%;
    position: relative;
    left: 30px;
    height: 200px;
  }
  main.maincontensegun {
    height: 10%;
    position: relative;
    top: 200px;
  }

  div.contenedorbutton {
    width: 50%;
    height: 60px;
    margin: 0 auto;
  }
  .divmaincontent {
    position: absolute;

    width: 80%;
    height: 400px;
    left: 40px;
    top: 420px;
  }

  div main.maincontenregistro {
    border-radius: 10px;
    background-color: #ffffff;
    margin: 0 auto;
    width: 90%;

    height: 400px;
  }

  main div button {
    width: 100%;
    height: 50px;
    position: relative;
    left: 5px;
    font-size: 24px;
    color: #ffffff;
    border: none;
    border-radius: 40px;
    background-color: #da3636;
  }
  main .contencuentaoff .cuentaoff {
    width: 80%;
    padding-left: 8px;
  }
  .cuentaoff a {
    font-size: 20px;
    color: rgb(29, 28, 28);
  }

  .conttitlewelcome {
    text-align: center;
  }
}

@media screen and (min-width: 430px) and (max-height: 658px) {
  .divlogo img.logo {
    width: 70%;
    position: relative;
    left: 30px;
    height: 200px;
  }
  main.maincontensegun {
    height: 10%;
    position: relative;
    top: 200px;
  }

  div.contenedorbutton {
    width: 50%;
    height: 60px;
    margin: 0 auto;
  }
  .divmaincontent {
    position: absolute;

    width: 80%;
    height: 400px;
    left: 40px;
    top: 420px;
  }

  div main.maincontenregistro {
    border-radius: 10px;
    background-color: #ffffff;
    margin: 0 auto;
    width: 90%;

    height: 400px;
  }

  main div button {
    width: 30%;
    /* height: 50px; */
    position: relative;
    /* left: 5px; */
    font-size: 20px;
    color: #ffffff;
    border: none;
    /* border-radius: 40px; */
    /* background-color: #da3636; */
  }
  main .contencuentaoff .cuentaoff {
    width: 80%;
    padding-left: 8px;
  }
  .cuentaoff a {
    font-size: 20px;
    color: rgb(29, 28, 28);
  }

  .conttitlewelcome {
    text-align: center;
  }
}
@media screen and (min-width: 412px) and (min-height: 914px) {
  .divlogo img.logo {
    width: 100%;
    position: relative;
    left: 5px;
    height: 200px;
  }
}
@media screen and (min-width: 500px) and (max-height: 760px) {
  .divlogo img.logo {
    width: 65%;
    height: 200px;
    position: relative;
    left: 40px;
  }
  main.maincontensegun {
    height: 15%;
    position: relative;
    top: 210px;
  }

  div.contenedorbutton {
    width: 70%;
    height: 60px;
    margin: 0 auto;
  }

  /* main div button#buttonid {
    width: 80%;
    height: 50px;
    position: relative;
    left: 30px;
    font-size: 24px;
    color: #ffffff;
    border: none;
    border-radius: 40px;
    background-color: #da3636;
  } */

  div.cuentaoff {
    position: relative;
    width: 80%;
    font-size: 22px;
  }

  div main.maincontenregistro {
    border-radius: 10px;
    background-color: #ffffff;
    margin: 0 auto;
    width: 70%;
    height: 360px;
  }
  main div h1 {
    font-size: 28px;
    color: rgb(29, 28, 28);
  }

  /* div.divmaincontent {
            position: absolute;
            
            width: 100%;
            height: 400px;
            left: 10px;
            top: 400px;
        } */

  div.divmaincontent {
    position: absolute;
    /* margin: 0 auto; */
    left: 20px;
    width: 90%;
    height: 400px;
    top: 420px;
  }

  .cuentaoff a {
    font-size: 18px;
    color: rgb(29, 28, 28);
    text-decoration: none;
  }
}

@media screen and (min-width: 1050px) and (min-height: 650px) {
  .divlogo img.logo {
    width: 30%;
    position: relative;
    left: 230px;
    height: 200px;
  }
  main.maincontensegun {
    height: 10%;
    position: relative;
    top: 200px;
  }

  div.contenedorbutton {
    width: 50%;
    height: 60px;
    margin: 0 auto;
  }

  div main.maincontenregistro {
    border-radius: 10px;
    background-color: #ffffff;
    margin: 0 auto;
    width: 40%;
    height: 360px;
  }

  /* main div button#buttonid {
    width: 100%;
    height: 50px;
    position: relative;
    left: 5px;
    font-size: 24px;
    color: #ffffff;
    border: none;
    border-radius: 40px;
    background-color: #da3636;
  } */
  main .contencuentaoff .cuentaoff {
    width: 60%;
    padding-left: 8px;
  }
  .cuentaoff a {
    font-size: 20px;
    color: rgb(29, 28, 28);
  }

  .conttitlewelcome {
    text-align: center;
  }
}

@media only screen and (min-device-width: 768px) and (max-device-width: 1024px) and (orientation: portrait) {
  .divlogo img.logo {
    width: 30%;
    position: relative;
    left: 230px;
    height: 200px;
  }
  main.maincontensegun {
    height: 10%;
    position: relative;
    top: 200px;
  }

  div.contenedorbutton {
    width: 50%;
    height: 60px;
    margin: 0 auto;
  }

  div main.maincontenregistro {
    border-radius: 10px;
    background-color: #ffffff;
    margin: 0 auto;
    width: 40%;
    height: 360px;
  }

  /* main div button#buttonid {
    width: 100%;
    height: 50px;
    position: relative;
    left: 5px;
    font-size: 24px;
    color: #ffffff;
    border: none;
    border-radius: 40px;
    background-color: #da3636;
  } */
  main .contencuentaoff .cuentaoff {
    width: 60%;
    padding-left: 8px;
  }
  .cuentaoff a {
    font-size: 20px;
    color: rgb(29, 28, 28);
  }

  .conttitlewelcome {
    text-align: center;
  }
}

@media screen and (min-width: 757px) and (min-height: 1500px) {
  .divlogo img.logo {
    width: 50%;
    position: relative;
    left: 100px;
    height: 200px;
  }
  main.maincontensegun {
    height: 10%;
    position: relative;
    top: 200px;
  }

  div.contenedorbutton {
    width: 50%;
    height: 60px;
    margin: 0 auto;
  }

  div main.maincontenregistro {
    border-radius: 10px;
    background-color: #ffffff;
    margin: 0 auto;
    width: 80%;
    height: 360px;
  }
/* 
  main div button#buttonid {
    width: 100%;
    height: 50px;
    position: relative;
    left: 5px;
    font-size: 24px;
    color: #ffffff;
    border: none;
    border-radius: 40px;
    background-color: #da3636;
  } */
  main .contencuentaoff .cuentaoff {
    width: 90%;
    padding-left: 100px;
  }
  .cuentaoff a {
    font-size: 18px;
    color: rgb(29, 28, 28);
  }

  .conttitlewelcome {
    text-align: center;
  }

  div .contencontendor .divlogo {
    margin: 0 auto;
    width: 60%;
  }

  .divmaincontent {
    position: absolute;
    /* background: red; */
    width: 80%;
    height: 400px;
    left: 80px;
    top: 420px;
  }
  .divtitulo {
    margin: 0 auto;
    width: 40%;
  }
  div .divtitulo h1 {
    font-weight: 500;
    margin: 0;
    font-size: 50px;
    text-align: center;
    color: orange;
  }

  div h1 .smallcolor {
    color: #b8bbb9;
  }

  div.divlogo {
    margin: 0;
  }
}
.divsearch {
  width: 20%;
  margin: 0 auto;
  padding-left: 50px;
}

.divsearch input {
  border-radius: 10px;
  border: none;
  background-color: #da3636;
  color: aliceblue;
  font-size: 20px;
  width: 80%;
}

.divcontenedormenu {
  margin: 0 auto;
  height: 300px;
  width: 70%;
}

.divimgmenu {
  padding-left: 23px;
  width: 50%;
  margin: 0 auto;
  position: relative;
  bottom: 60px;
  border-radius: 80px;
}

.divmenu {
  margin: 0 auto;
  width: 70%;
}
.divmenu p {
  font-size: 23px;
}
.divmenu small {
  color: #da3636;
  font-size: 20px;
}

.divimgmenu img {
  border-radius: 50px;
}

.maincontenregistro {
  background-color: #f7d8da;
}

.conten-lefrigth{
  justify-content: space-between;
  display: flex;
}
.colfive-modif {
  display: flex;
}
.modal-footer {
    display: flex;
    flex-shrink: 0;
    flex-wrap: wrap;
    align-items: center;
    justify-content: flex-end;
    padding: calc(var(--bs-modal-padding) - var(--bs-modal-footer-gap) * .5);
    background-color: var(--bs-modal-footer-bg);
    border-top: var(--bs-modal-footer-border-width) solid var(--bs-modal-footer-border-color);
    border-bottom-right-radius: var(--bs-modal-inner-border-radius);
    border-bottom-left-radius: var(--bs-modal-inner-border-radius);
}

.Buscar {
  background: rgb(180, 178, 178);
}
</style>

<script >
export default {
  data() {
    return {
      codigo:'',
      nombre_producto: '',
      tipo_producto:'',
      precio_producto:'',
      respuesta:[],
      primertitle: "FAST",
      segindotitle: "FOOD",

      alerta:{
        tipo: '',
        message:''
      },
      modal:{
        title:'',
        id: null,
        data:{}
      },
      modaledit:{
        title:'',
        id: null,
        data:{}
      }
    };
  },
  methods: {
    add(codigo) {
      this.modal.title = "Registrar Producto";
      this.modal.id = codigo
      this.modal.data = {}

      $(this.$refs.modal).modal("show");
    },

    edit(id) {
      this.modaledit.title = "Editar Producto";
      this.modaledit.id = codigo
      this.modaledit.data ={}

      $(this.$refs.modaledit).modal("show");
    },

    save() {
      if (this.modal.id || this.modal.id === 0) {
        this.respuesta[this.modal.id] = this.modal.data;
        var endpoint = "http://localhost:8080/menu/guardar";
        var opciones = {
          method: "POST",
          headers: { "Content-type": "Application/json" },
          body: JSON.stringify({
            codigo: this.codigo,
            nombre_producto: this.nombre_producto,
            tipo_producto: this.tipo_producto,
            precio_producto: this.precio_producto,
          }),
        };
        fetch(endpoint, opciones).then(async (Response) => {
          try {
            if (Response.status)
              Swal.fire({
                icon: "success",
                title: "Correcto",
                text: "Registrado correctamente",
              });
              this.codigo=null,
              this.nombre_producto=''
              this.tipo_producto='',
              this.precio_producto=''
             
          } catch (error) {
            return '{"sucess":false ,"message":"Error, Intentalo nuevamente."}';
          }
        });
        this.respuesta.push({codigo: this.codigo,
            nombre_producto: this.nombre_producto,
            tipo_producto: this.tipo_producto,
            precio_producto: this.precio_producto});
      }
    
    },

    verproductos(){
    var endpoint = "http://localhost:8080/menu/ver";
    var opciones = {method:"GET"}
    fetch(endpoint, opciones).then(async response => {
          this.respuesta = await response.json();
            }) 

    },
    async BuscarProductoId() {
            var endpoint = "http://localhost:8080/menu/verid/" + this.codigo;
            var opciones = { method: "GET" };
            fetch(endpoint, opciones)
                .then(response => response.json())
                .then(data => { this.respuesta = data; console.log(data) })
        },

   ActualizarProducto() {
            var endpoint = "http://localhost:8080/menu/guardar";
            var opciones = {
                method: "POST",
                headers: { "Content-type": "Application/json" },
                body: JSON.stringify({
                   codigo: this.respuesta.codigo,
                   nombre_producto:this.respuesta.nombre_producto,
      tipo_producto:this.respuesta.tipo_producto,
      precio_producto:this.respuesta.precio_producto
                 })
            }
            fetch(endpoint, opciones).then(async Response => {
                // alert('Guardado Correctamente');
                try {
                    if (Response.status)
                        Swal.fire({
                            icon: 'question',
                            title: 'Desea Actualizar Menu?',
                            showDenyButton: true,
                            showCancelButton: false,
                            confirmButtonText: 'Actualizar',
                            denyButtonText: `Cancelar`,
                        }).then((result) => {
                            if (result.isConfirmed) {
                                Swal.fire('Actualizado con exito', '', 'success')
                                this.respuesta.codigo="",
                                this.respuesta.nombre_producto="",
                                this.respuesta.tipo_producto="",
                                this.respuesta.precio_producto=""
                           
                                this.verproductos();

                            } else if (result.isDenied) {
                                Swal.fire('Los cambios no se Actualizaron', '', 'warning')
                                return false
                            }
                        })
                    else {
                        alert("error")
                    }
                } catch (error) {
                    return "{\"sucess\":false ,\"message\":\"Error al intentar actualizar.\"}";
                }
            })
        },



  eliminarproducto() {
            var endpoint = "http://localhost:8080/menu/eliminar/" + this.codigo;
            var opciones = { method: "DELETE" };
            fetch(endpoint, opciones)
                .then(response => response.json())
                .then(data => { this.respuesta = data; console.log(data) })
                alert("Usuario con codigo Eliminado con Exito ");
                this.verproductos();
        }
    //cierre del methods:{}
  },
  //cierre de export default{}
}
</script>