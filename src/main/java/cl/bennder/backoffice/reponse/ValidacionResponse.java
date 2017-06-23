package cl.bennder.backoffice.reponse;

import cl.bennder.backoffice.model.Validacion;

public class ValidacionResponse {
    private Validacion validacion;

    public ValidacionResponse() {
    }

    public ValidacionResponse(Validacion validacion) {
        this.validacion = validacion;
    }
    //evitamos crear objetos sino se utiliza, solo on demand
    public Validacion getValidacion() {
        if(this.validacion == null){
            this.validacion = new Validacion();
        }
        return validacion;
    }

    public void setValidacion(Validacion validacion) {
        this.validacion = validacion;
    }
    
    
}