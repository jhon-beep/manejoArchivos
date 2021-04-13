
package DefensaLaboratorio_I;

import java.io.Serializable;

public class MaterialBibliografico  implements Serializable{
     static final long serialVersionUID=42L;  
    private String titulo;
     private String autor ;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
     
}
