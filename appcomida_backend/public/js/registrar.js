

const app = new Vue({
    el: "#app",

    data: {
        id: "",
        nombre: "",
        apellido: "",
        usuario: "",
        correo: "",
        password: ""
    },

    methods: {

        registrar: async function (event) {
            try {

                url = "http://localhost:8080/clientes/guardar"

                let response = await fetch(url, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        id: this.id,
                        nombre: this.nombre,
                        apellido: this.apellido,
                        usuario: this.usuario,
                        correo: this.correo,
                        password: this.password
                    })

                }).then((response) => response.json())
                    .then(data => data)
                    .catch(error => console.log(error))


                if (response.success == true)
                    swal({
                        title: "Exito!",
                        text: "Menu almacenado correctamente",
                        icon: "success"
                    })
                else
                    swal({
                        title: "Error!",
                        text: "No se pudo almacenar el menu",
                        icon: "error"
                    })

                console.log(response)

            } catch (error) {
                swal({
                    title: "Error!",
                    text: "Ocurrió un error al intertar comunicarnos con el servidor :(",
                    icon: "error"
                })

            }
        }

    }
})