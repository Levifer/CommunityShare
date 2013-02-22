package Domein;

import java.awt.image.BufferedImage;



public class Foto
{
    private int fotoNr;
    private BufferedImage foto;

    
    public Foto(int fotoNr, BufferedImage foto) 
    {
        this.fotoNr = fotoNr;
        this.foto = foto;
    }

    public int getFotoNr() {
        return fotoNr;
    }

    public void setFotoNr(int fotoNr) {
        this.fotoNr = fotoNr;
    }

    public BufferedImage getFoto() {
        return foto;
    }

    public void setFoto(BufferedImage foto) {
        this.foto = foto;
    }
    
    
    
}
