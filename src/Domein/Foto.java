package Domein;

import java.awt.image.BufferedImage;



public class Foto
{
    private int FotoNr;
    private BufferedImage Foto;

    
    public Foto(int FotoNr, BufferedImage Foto) 
    {
        this.FotoNr = FotoNr;
        this.Foto = Foto;
    }

    public int getFotoNr() {
        return FotoNr;
    }

    public void setFotoNr(int FotoNr) {
        this.FotoNr = FotoNr;
    }

    public BufferedImage getFoto() {
        return Foto;
    }

    public void setFoto(BufferedImage Foto) {
        this.Foto = Foto;
    }
    
    
    
}
