package example.demo3;

import java.net.URL;

public class ImageEntity {
    private String popis;
    private String autor;

    private String url;

    public ImageEntity(){
        this("Anonym", "test", null);
    }
    public ImageEntity(String autor, String popis, String url){
        this.autor = autor;
        this.popis = popis;
        this.url = url;
    }
    public String getPopis(){return this.popis;}
    public String getAutor(){return this.autor;}
    public void setPopis(String popis){this.popis = popis;}
    public void setAutor(String autor){this.autor = autor;}
    public String getUrl(){return this.url;}
    public void setUrl(String url){ this.url = url;}
}
