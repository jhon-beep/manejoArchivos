
package DefensaLaboratorio_I  ;

import java.io.Serializable;


public class Libro extends MaterialBibliografico   {
   
    private int  edicion; 
     private String  area ;   
   public void mostrar() {
 
        System.out.println("Titulo" + super.getTitulo());
        System.out.println("autor   " + super.getAutor());
        System.out.println("edicion  " + edicion);
        System.out.println("area   " + area);
    }
    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }



    
}
