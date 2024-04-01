

const app = new Vue({
    el: "#app",

    data: {
        user: "",
        password: "",
        primertitle: "FAST",
        segindotitle: "FOOD",
        subtitle: "Bienvenido a Fast Food",
        olclave: "Olvido su Contraseña?"
    },

    methods: {

        login: async function (event) {
            try {

                url = "http://localhost:8080/usuarios/login"

                let response = await fetch(url, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        user: this.user,
                        password: this.password
                    })

                }).then((response) => response.json())
                    .then(data => data)
                    .catch(error => console.log(error))


                if (response.success == true)
                    location.href = "index_user.html"
                else
                    swal({
                        title: "Error!",
                        text: "Usuario o contraseña incorrecta!!! :(",
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