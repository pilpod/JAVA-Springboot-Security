
export default class AuthController {

    private url: String = 'http://localhost:8080/api/v1'
    private auth: String = ""

    async login(username: String, password: String): Promise<Response> {

        this.auth = this.encodeB64(username,password)

        const myHeader = new Headers()
        myHeader.append('Content-Type', 'application/json')
        myHeader.append('Authorization', `Basic ${this.auth}`)

        const response = await fetch(this.url + '/login', {
            method: 'GET',
            headers: myHeader,
            redirect: 'follow',
        })
        return response
    }

    encodeB64(username: String, password: String): String {
        const encodedData = window.btoa(`${username}:${password}`)
        return encodedData
    }
}
