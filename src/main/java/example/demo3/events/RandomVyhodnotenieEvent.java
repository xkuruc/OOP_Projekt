package example.demo3.events;

import example.demo3.pouzivatelia.Profesional;
import example.demo3.pouzivatelia.Uzivatel;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RandomVyhodnotenieEvent implements EventHandler{
    private ImageService imageService;
    private UserService userService;

    public RandomVyhodnotenieEvent(ImageService imageService, UserService userService){
        this.imageService = imageService;
        this.userService = userService;
    }
    @Override
    public void handle() {

        //tu sa hodi multihreading, lebo nemusime cakat na vyhodnotenie 1 obrazka aby sme mohli vyhodnotit dalsi, mozme vyhodnotit vsetky naraz
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Random rand = new Random();
        for (Uzivatel uzivatel : userService.returnObjectArray()) {
            if (uzivatel instanceof Profesional) {
                ((Profesional) uzivatel).vymazSuperHodnotenie();
            }
            uzivatel.setOhodnoteneObrasky(new ArrayList<>());
            uzivatel.setHodnotenia(new ArrayList<>());


            for (ImageEntity image : imageService.returnObjectArray()) {
                executor.submit(() -> {
                    int randomNumber = rand.nextInt(4) + 1;
                    image.updateHodnotenie(uzivatel, randomNumber);
                    uzivatel.updateHodnotenie(image, randomNumber);
                });
            }
        }
        executor.shutdown();
    }
}
