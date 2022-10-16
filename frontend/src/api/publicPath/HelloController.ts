export default class HelloController {
  url: string = "http://localhost:8080/api/v1/helloworld";

  async getHelloWord() {
    const response = await fetch(this.url);
    const data = await response.json();
    return data;
  }
}
