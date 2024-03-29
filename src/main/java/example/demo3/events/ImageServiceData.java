package example.demo3;

import java.util.ArrayList;

public class ImageServiceData {
    public static ArrayList<ImageEntity> imageEntityArrayList;
    public static ImageEntity ObrazokDna;
    public static String destination;
    private int width = 500;
    private int height = 500;
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public void setWidth(int width){
        this.width=width;
    }
    public void setHeight(int height){
        this.height= height;
    }
}
