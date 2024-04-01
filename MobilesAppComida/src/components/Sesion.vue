<script>
export default{
data() {
    return {
        name:"Sesion",
          correo: '',
          password: '',
          primertitle: "FAST",
          segindotitle: "FOOD",
          subtitle: "Bienvenido a Fast Food",
          login: "Login",
          olclave: "Olvido su Contraseña?"
        
    }
},
methods: {
        
        loginOn: async function () {
          var endpoint = 'http://localhost:8080/clientes/Login/' + this.correo;
          var opciones = {
            method: 'GET',
            headers: {
              "Content-type": "Application/json",
              'Access-Control-Allow-Origin':'*',
              'Access-Control-Allow-Headers':'Authorization'
            }
          };
          fetch(endpoint, opciones).then(async response => {
            const respuesta = await response.json();

         try {
          if (respuesta.length >= 1) {
              Swal.fire({
                width: 300,
                icon: 'success',
                title: 'Correcto',
                text: "Usuario Registrado",
                showConfirmButton: false,
                timer: 500
              })
              this.$router.push('/Registro/menu');
            }
            else if (!respuesta.length) {
              Swal.fire({
                width: 300,
                icon: 'question',
                title: 'Error',
                text: "Usuario no encontrado",
                showConfirmButton: false,
                timer: 500
              })
            }
            else
              Swal.fire({
                width: 300,
                icon: 'error',
                title: 'Error',
                text: "Usuario o Clave Incorrectos",
                showConfirmButton: false,
                timer: 2000
              })
            // console.log(response)

         } catch (error) {
          Swal.fire({
                width: 300,
                icon: 'error',
                title: 'Error',
                text: "Error!! request server",
                showConfirmButton: false,
                timer: 2000
              })
          
         }
          }).then(data => data)
            .catch(error => console.log(error));
        }

      },



}
</script>

<template>
    
    <main class="maincontenapp">
      <div class="contendor">
        <div class="contencontendor">
          <div class="divlogo">
            <img class="logo" src="../assets/Img/fasfood2.jpg" alt="">
          </div>

          <div class="divtitulo">
            <h1 class="h1color">{{primertitle}}<small class="smallcolor">{{segindotitle}}</small></h1>

          </div>

        </div>

      </div>
    </main>

    <div class="divmaincontent">

      <main class="maincontenregistro">
        <div class="conttitlewelcome">
          <h1>{{subtitle}}</h1>
        </div>
        <form>
          <div class="contenidoinputs">
            <div class="divinputs">
              <input type="email" name="correo" id="correo" v-model="correo" placeholder="Email.">
            </div>
            <div class="divinputs">
              <input type="password" name="password" id="password" v-model="password" placeholder="Password."
                autocomplete="off">
            </div>

          </div>
          <div class="contenedorbutton">
            <!-- <a class="classignup" href=""> -->
            <button type="button" v-on:click="loginOn">{{login}}</button>
            <!-- </a> -->
          </div>
        </form>

        <div class="contencuentaoff">
          <div class="cuentaoff">
            <a class="classignup" href="">{{ olclave}}</a>
          </div>

        </div>
      </main>
    </div>

</template>

<style scoped>
* {
    box-sizing: border-box;
  }

.bodysession{
    height: 1000px;
    
}



.idapp{
    background-image: url("../img/hambur3.jpg");
    background-repeat: no-repeat;
    background-position: center;
    height: 500px;
} 

div .contencontendor .divlogo{
    margin: 0 auto;
    width: 50%;

}


/* div .divtitulo{
    font-size: 26px;
    margin: 0 auto;
} */

div .divtitulo h1{
    font-weight: 500;
    margin: 0;
    font-size: 50px;
    text-align: center;
    color:orange;
}

div h1 .smallcolor{
    color:#b8bbb9;
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

div main.maincontenregistro{
    border-radius: 10px;
    background-color:#ffffff;
    margin: 0 auto;
    width: 40%;
   height: 360px;
}
main div h1{
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

.contenidoinputs{
    width: 80%;
    margin: 0 auto;
    
}

.divinputs{
    padding: 0.3rem;
}

.contenidoinputs .divinputs input{
    border: none;
    width: 100%;
    
    border-bottom: 1px solid;
    height: 30px;
}

.contenedorbutton{
    position: relative;
    top: 100px;
    width: 70%;
    height:40px;
    margin: 0 auto;
}

button{
    width: 90%;
    height: 40px;
   
    font-size: 24px;
    color: #ffffff;
    border: none;
    border-radius: 40px;
    background-color:#da3636;
}

.contencuentaoff{
    position: relative; 
    top:110px;
}

.cuentaoff{
    font-size: 16px;
    font-family:Verdana, Geneva, Tahoma, sans-serif;
    width: 80%;
    padding-left: 20px;
    margin: 0 auto;
   
}

.cuentaoff a {
    color: rgb(29, 28, 28);
    text-decoration: none;
}


.conttitlewelcome{
    text-align: center;
}


/* //////////////////////////////////777MEDIAA QUERYS */
    @media screen and (min-width:268px) and (max-width:429px){
        .divlogo img.logo {
            width: 100%; 
            position: relative;
            left: 30px;
            height: 200px; 
        } 
        main.maincontensegun{
            height: 10%;
            position: relative;
            top:200px;
        }
        
        div.contenedorbutton{
            width: 50%;
            height:60px;
            margin: 0 auto;
        }
        .divmaincontent {
            position: absolute;
        
            width: 80%;
            height: 400px;
            left: 40px;
            top: 420px;
        }
        

        div main.maincontenregistro{
            border-radius: 10px;
            background-color:#ffffff;
            margin: 0 auto;
            width: 90%;
        
        height:400px;
        }

        main div button{
            width: 100%;
            height: 50px;
            position: relative;
            left: 5px;
            font-size: 24px;
            color: #ffffff;
            border: none;
            border-radius: 40px;
            background-color:#da3636;
        }
        main .contencuentaoff .cuentaoff{
            width: 80%;
        padding-left: 8px;
        }
        .cuentaoff a {
            font-size: 20px;
            color: rgb(29, 28, 28);
        
        }
        
        .conttitlewelcome{
            text-align: center;
        }
    }

    @media screen and (min-width: 430px) and (max-height:658px){

        .divlogo img.logo {
            width: 70%; 
            position: relative;
            left: 30px;
            height: 200px; 
        } 
        main.maincontensegun{
            height: 10%;
            position: relative;
            top:200px;
        }
        
        div.contenedorbutton{
            width: 50%;
            height:60px;
            margin: 0 auto;
        }
        .divmaincontent {
            position: absolute;
        
            width: 80%;
            height: 400px;
            left: 40px;
            top: 420px;
        }
        

        div main.maincontenregistro{
            border-radius: 10px;
            background-color:#ffffff;
            margin: 0 auto;
            width: 90%;
        
        height:400px;
        }

        main div button{
            width: 100%;
            height: 50px;
            position: relative;
            left: 5px;
            font-size: 24px;
            color: #ffffff;
            border: none;
            border-radius: 40px;
            background-color:#da3636;
        }
        main .contencuentaoff .cuentaoff{
            width: 80%;
        padding-left: 8px;
        }
        .cuentaoff a {
            font-size: 20px;
            color: rgb(29, 28, 28);
        
        }
        
        .conttitlewelcome{
            text-align: center;
        }
    }
    @media screen and  (min-width:412px) and (min-height:914px){
        .divlogo img.logo {
            width: 100%; 
            position: relative;
            left: 5px;
            height: 200px; 
        } 
    }
    @media screen and (min-width: 500px) and (max-height:760px) {

        .divlogo img.logo {
            width: 65%;
            height: 200px;
            position: relative;
            left: 40px;
        }
        main.maincontensegun{
            height: 15%;
            position: relative;
            top:210px;
        }
        
        div.contenedorbutton{
            width: 70%;
            height:60px;
            margin: 0 auto;
        }
        
        main div button{
            width: 80%;
            height: 50px;
            position: relative;
            left: 30px;
            font-size: 24px;
            color: #ffffff;
            border: none;
            border-radius: 40px;
            background-color:#da3636;
        }
        
        div.cuentaoff {
            position: relative;
            width: 80%;
            font-size:  22px;  
        }

        div main.maincontenregistro{
            border-radius: 10px;
            background-color:#ffffff;
            margin: 0 auto;
            width: 70%;
        height: 360px;
        }
        main div h1{
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


        @media screen and (min-width:1050px) and (min-height:650px){


            .divlogo img.logo {
                width: 30%; 
                position: relative;
                left: 230px;
                height: 200px; 
            } 
            main.maincontensegun{
                height: 10%;
                position: relative;
                top:200px;
            }
            
            div.contenedorbutton{
                width: 50%;
                height:60px;
                margin: 0 auto;
            }

            div main.maincontenregistro{
                border-radius: 10px;
                background-color:#ffffff;
                margin: 0 auto;
                width: 40%;
            height: 360px;
            }

            main div button{
                width: 100%;
                height: 50px;
                position: relative;
                left: 5px;
                font-size: 24px;
                color: #ffffff;
                border: none;
                border-radius: 40px;
                background-color:#da3636;
            }
            main .contencuentaoff .cuentaoff{
                width: 60%;
            padding-left: 8px;
            }
            .cuentaoff a {
                font-size: 20px;
                color: rgb(29, 28, 28);
            
            }
            
            
            .conttitlewelcome{
                text-align: center;
            }
        }
        
        @media only screen and (min-device-width : 768px) and (max-device-width : 1024px) and (orientation : portrait){
        .divlogo img.logo {
            width: 30%; 
            position: relative;
            left: 230px;
            height: 200px; 
        } 
        main.maincontensegun{
            height: 10%;
            position: relative;
            top:200px;
        }
        
        div.contenedorbutton{
            width: 50%;
            height:60px;
            margin: 0 auto;
        }

        div main.maincontenregistro{
            border-radius: 10px;
            background-color:#ffffff;
            margin: 0 auto;
            width: 40%;
        height: 360px;
        }

        main div button{
            width: 100%;
            height: 50px;
            position: relative;
            left: 5px;
            font-size: 24px;
            color: #ffffff;
            border: none;
            border-radius: 40px;
            background-color:#da3636;
        }
        main .contencuentaoff .cuentaoff{
            width: 60%;
        padding-left: 8px;
        }
        .cuentaoff a {
            font-size: 20px;
            color: rgb(29, 28, 28);
        
        }
        
        
        .conttitlewelcome{
            text-align: center;
        }
    }

    @media screen and   (min-width:757px) and (min-height: 1500px){
        .divlogo img.logo {
            width: 50%; 
            position: relative;
            left: 100px;
            height: 200px; 
        } 
        main.maincontensegun{
            height: 10%;
            position: relative;
            top:200px;
        }
        
        div.contenedorbutton{
            width: 50%;
            height:60px;
            margin: 0 auto;
        }

        div main.maincontenregistro{
            border-radius: 10px;
            background-color:#ffffff;
            margin: 0 auto;
            width: 80%;
        height: 360px;
        }

        main div button{
            width: 100%;
            height: 50px;
            position: relative;
            left: 5px;
            font-size: 24px;
            color: #ffffff;
            border: none;
            border-radius: 40px;
            background-color:#da3636;
        }
        main .contencuentaoff .cuentaoff{
            width: 90%;
        padding-left: 100px;
        }
        .cuentaoff a {
            font-size: 18px;
            color: rgb(29, 28, 28);
        
        }
        
        
        .conttitlewelcome{
            text-align: center;
        }

        div .contencontendor .divlogo{
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
        .divtitulo{
            margin: 0 auto;
            width: 40%;
        
        }
        div .divtitulo h1{
            font-weight: 500;
            margin: 0;
            font-size: 50px;
            text-align: center;
            color:orange;
        }
        
        div h1 .smallcolor{
            color:#b8bbb9;
        }
        
    div.divlogo{
        margin:0;
    }
    }
</style>