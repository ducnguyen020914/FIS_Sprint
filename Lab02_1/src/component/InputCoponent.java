package component;

import dao.IValidate;

public class InputCoponent {
    private IValidate validate;
    private String data;

    public void setData(String data) {
        this.data = data;
    }
    void display(){

    }

    public void setValidate(IValidate validate) {
        this.validate = validate;
    }
    boolean validate(){
        return false;

    }

}
