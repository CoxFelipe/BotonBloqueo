import javax.management.Notification;
import java.util.EventListener;
import java.util.EventObject;
import java.util.Vector;

public class Bloqueo {

private Vector ListenerBloqueo = new Vector();

    public Bloqueo(){


    }

    public void bloquear (String NuevoBloqueo){


            BloqueoEvent event=new BloqueoEvent( this, NuevoBloqueo);
            notificarCambio(event);


    }

    public synchronized void addBloqueoListener(BloqueoListener listener){
        ListenerBloqueo.addElement(listener);

    }

    private void notificarCambio(BloqueoEvent event){
        Vector lista;
        synchronized(this){
            lista=(Vector)ListenerBloqueo.clone();
        }
        for(int i=0; i<lista.size(); i++){
            BloqueoListener listener=(BloqueoListener) lista.elementAt(i);
            listener.notificarSesion(event);
        }
    }


}

class BloqueoEvent extends EventObject{
    /**
     * Constructs a prototypical Event.
     *
     * @param objet The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */

    protected String c ;
    public BloqueoEvent(Object objet, String cuen) {
        super(objet);

        this.c= cuen;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}

interface BloqueoListener extends EventListener{

    public void notificarSesion(EventObject o);

}


