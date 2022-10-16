export default class MessageModel {
  private _message: String;

  constructor(message: String) {
    this._message = message;
  }

  public get message(): String {
    return this._message;
  }

  public set message(value: String) {
    this._message = value;
  }
}
