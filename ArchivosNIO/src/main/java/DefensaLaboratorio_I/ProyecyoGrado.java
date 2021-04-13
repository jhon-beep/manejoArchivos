
package DefensaLaboratorio_I;

import java.io.Serializable;

public class ProyecyoGrado extends MaterialBibliografico {
    
     
    private String tutor;
     private String revisor;
    public void mostrar() {
        System.out.println("Titulo  " + super.getTitulo());
        System.out.println("autor   " + super.getAutor());
        System.out.println("tutor   " +tutor);
        System.out.println("revisor   " +revisor); 

    }
    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }
     
}
