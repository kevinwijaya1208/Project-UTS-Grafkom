import Engine.*;
import Engine.Object;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(1000, 1000, "Hello World");
    Wawatchi wawatchi = new Wawatchi();
    Tamatchi tamatchi = new Tamatchi();
    Hikotchi hikotchi = new Hikotchi();
    MouseInput mouseInput;

    boolean gantiGambar = false;
    int gambarSekarang = 0;

    public void init() {
        window.init();
        GL.createCapabilities();
        glEnable(GL_DEPTH_TEST);
//        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
//        glDepthMask(true);
//        glDepthFunc(GL_LEQUAL);
//        glDepthRange(0.0f, 1.0f);
        mouseInput = window.getMouseInput();
        wawatchi.init();
        tamatchi.init();
        hikotchi.init();
        wawatchi.translateObject(0.0f, -0.5f, 0.0f);
        tamatchi.translateObject(0.5f, 0.2f, 0.0f);
        hikotchi.translateObject(-0.4f, 0.1f, 0.0f);
    }

    public void input() {
        // Rotate
        if(window.isKeyPressed(GLFW_KEY_Q)) {
            Vector3f tempCenterPoint1 = wawatchi.objectsSphere.get(11).updateCenterPoint();
            wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
            wawatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 0.0f, 1.0f);
            wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x, tempCenterPoint1.y,tempCenterPoint1.z);
            Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
            tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
            tamatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 0.0f, 1.0f);
            tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
            Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
            for (int x = 0; x <= 9; x++) {
                hikotchi.objectsSphere.get(x).translateObject(
                        -tempCenterPoint3.x,
                        -tempCenterPoint3.y,
                        -tempCenterPoint3.z
                );
                hikotchi.objectsSphere.get(x).rotateObject(0.01f, 0.0f, 0.0f, 1.0f);
                hikotchi.objectsSphere.get(x).translateObject(
                        tempCenterPoint3.x,
                        tempCenterPoint3.y,
                        tempCenterPoint3.z
                );
            }
        }

        if(window.isKeyPressed(GLFW_KEY_E)) {
            Vector3f tempCenterPoint1 = wawatchi.objectsSphere.get(11).updateCenterPoint();
            wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
            wawatchi.objectsSphere.get(0).rotateObject(-0.01f, 0.0f, 0.0f, 1.0f);
            wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x, tempCenterPoint1.y,tempCenterPoint1.z);
            Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
            tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
            tamatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 0.0f, -1.0f);
            tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
            Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
            for (int x = 0; x <= 9; x++) {
                hikotchi.objectsSphere.get(x).translateObject(
                        -tempCenterPoint3.x,
                        -tempCenterPoint3.y,
                        -tempCenterPoint3.z
                );
                hikotchi.objectsSphere.get(x).rotateObject(0.01f, 0.0f, 0.0f, -1.0f);
                hikotchi.objectsSphere.get(x).translateObject(
                        tempCenterPoint3.x,
                        tempCenterPoint3.y,
                        tempCenterPoint3.z
                );
            }
        }

        if(window.isKeyPressed(GLFW_KEY_W)) {
            Vector3f tempCenterPoint1 = wawatchi.objectsSphere.get(0).updateCenterPoint();
            wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
            wawatchi.objectsSphere.get(0).rotateObject(0.01f, 1.0f, 0.0f, 0.0f);
            wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);
            Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
            tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
            tamatchi.objectsSphere.get(0).rotateObject(0.01f, 1.0f, 0.0f, 0.0f);
            tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
            Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
            for (int x = 0; x <= 9; x++) {
                hikotchi.objectsSphere.get(x).translateObject(
                        -tempCenterPoint3.x,
                        -tempCenterPoint3.y,
                        -tempCenterPoint3.z
                );
                hikotchi.objectsSphere.get(x).rotateObject(0.01f, 1.0f, 0.0f, 0.0f);
                hikotchi.objectsSphere.get(x).translateObject(
                        tempCenterPoint3.x,
                        tempCenterPoint3.y,
                        tempCenterPoint3.z
                );
            }
        }

        if(window.isKeyPressed(GLFW_KEY_S)) {
            Vector3f tempCenterPoint1 = wawatchi.objectsSphere.get(0).updateCenterPoint();
            wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
            wawatchi.objectsSphere.get(0).rotateObject(-0.01f, 1.0f, 0.0f, 0.0f);
            wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);
            Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
            tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
            tamatchi.objectsSphere.get(0).rotateObject(-0.01f, 1.0f, 0.0f, 0.0f);
            tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
            Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
            for (int x = 0; x <= 9; x++) {
                hikotchi.objectsSphere.get(x).translateObject(
                        -tempCenterPoint3.x,
                        -tempCenterPoint3.y,
                        -tempCenterPoint3.z
                );
                hikotchi.objectsSphere.get(x).rotateObject(0.01f, -1.0f, 0.0f, 0.0f);
                hikotchi.objectsSphere.get(x).translateObject(
                        tempCenterPoint3.x,
                        tempCenterPoint3.y,
                        tempCenterPoint3.z
                );
            }
        }

        if(window.isKeyPressed(GLFW_KEY_A)) {
            Vector3f tempCenterPoint1 =  wawatchi.objectsSphere.get(0).updateCenterPoint();
            wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
            wawatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 1.0f, 0.0f);
            wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);
            Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
            tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
            tamatchi.objectsSphere.get(0).rotateObject(0.01f, 0.0f, 1.0f, 0.0f);
            tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
            Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
            for (int x = 0; x <= 9; x++) {
                hikotchi.objectsSphere.get(x).translateObject(
                        -tempCenterPoint3.x,
                        -tempCenterPoint3.y,
                        -tempCenterPoint3.z
                );
                hikotchi.objectsSphere.get(x).rotateObject(0.01f, 0.0f, 1.0f, 0.0f);
                hikotchi.objectsSphere.get(x).translateObject(
                        tempCenterPoint3.x,
                        tempCenterPoint3.y,
                        tempCenterPoint3.z
                );
            }
        }

        if(window.isKeyPressed(GLFW_KEY_D)) {
            Vector3f tempCenterPoint1 =  wawatchi.objectsSphere.get(0).updateCenterPoint();
            wawatchi.objectsSphere.get(0).translateObject(-tempCenterPoint1.x, -tempCenterPoint1.y,-tempCenterPoint1.z);
            wawatchi.objectsSphere.get(0).rotateObject(-0.01f, 0.0f, 1.0f, 0.0f);
            wawatchi.objectsSphere.get(0).translateObject(tempCenterPoint1.x,tempCenterPoint1.y,tempCenterPoint1.z);
            Vector3f tempCenterPoint2 =  tamatchi.objectsSphere.get(0).updateCenterPoint();
            tamatchi.objectsSphere.get(0).translateObject(-tempCenterPoint2.x, -tempCenterPoint2.y,-tempCenterPoint2.z);
            tamatchi.objectsSphere.get(0).rotateObject(-0.01f, 0.0f, 1.0f, 0.0f);
            tamatchi.objectsSphere.get(0).translateObject(tempCenterPoint2.x,tempCenterPoint2.y,tempCenterPoint2.z);
            Vector3f tempCenterPoint3 =  hikotchi.objectsSphere.get(0).updateCenterPoint();
            for (int x = 0; x <= 9; x++) {
                hikotchi.objectsSphere.get(x).translateObject(
                        -tempCenterPoint3.x,
                        -tempCenterPoint3.y,
                        -tempCenterPoint3.z
                );
                hikotchi.objectsSphere.get(x).rotateObject(0.01f, 0.0f, -1.0f, 0.0f);
                hikotchi.objectsSphere.get(x).translateObject(
                        tempCenterPoint3.x,
                        tempCenterPoint3.y,
                        tempCenterPoint3.z
                );
            }
        }


        // Translate
        if(window.isKeyPressed(GLFW_KEY_U)) {
            wawatchi.objectsSphere.get(0).translateObject(0.0f, 0.0f, 0.01f);
        }

        if(window.isKeyPressed(GLFW_KEY_O)) {
            wawatchi.objectsSphere.get(0).translateObject(0.0f, 0.0f, -0.01f);
        }

        if(window.isKeyPressed(GLFW_KEY_I)) {
            wawatchi.objectsSphere.get(0).translateObject(0.0f, 0.005f, 0.0f);
            tamatchi.objectsSphere.get(0).translateObject(0.0f, 0.005f, 0.0f);
            for (Sphere sphere : hikotchi.objectsSphere) {
                sphere.translateObject(
                        0f,
                        0.005f,
                        0f
                );
            }
        }

        if(window.isKeyPressed(GLFW_KEY_K)) {
            wawatchi.objectsSphere.get(0).translateObject(0.0f, -0.005f, 0.0f);
            tamatchi.objectsSphere.get(0).translateObject(0.0f, -0.005f, 0.0f);
            for (Sphere sphere : hikotchi.objectsSphere) {
                sphere.translateObject(
                        0f,
                        -0.005f,
                        0f
                );
            }
        }

        if(window.isKeyPressed(GLFW_KEY_J)) {
            wawatchi.objectsSphere.get(0).translateObject(-0.005f, 0.0f, 0.0f);
            tamatchi.objectsSphere.get(0).translateObject(-0.005f, 0.0f, 0.0f);
            for (Sphere sphere : hikotchi.objectsSphere) {
                sphere.translateObject(
                        -0.005f,
                        0f,
                        0f
                );
            }
        }

        if(window.isKeyPressed(GLFW_KEY_L)) {
            wawatchi.objectsSphere.get(0).translateObject(0.005f, 0.0f, 0.0f);
            tamatchi.objectsSphere.get(0).translateObject(0.005f, 0.0f, 0.0f);
            for (Sphere sphere : hikotchi.objectsSphere) {
                sphere.translateObject(
                        0.005f,
                        0f,
                        0f
                );
            }
        }

        if (window.isKeyPressed(GLFW_KEY_0)){
            tamatchi.objectsSphere.get(6).rotateObject((float) Math.toRadians(tamatchi.limitKakiKiri), 1.0f, 0.0f, 0.0f);
            tamatchi.objectsSphere.get(7).rotateObject((float) Math.toRadians(tamatchi.limitKakiKanan), -1.0f, 0.0f, 0.0f);


            if (tamatchi.limitKakiKiri >= 0.5f) {
                tamatchi.jarak *= -1;
            } else if (tamatchi.limitKakiKiri < -1f) {
                tamatchi.jarak *= -1;
            }

            if (tamatchi.limitKakiKanan >= 0.5f) {
                tamatchi.jarak *= -1;
            } else if (tamatchi.limitKakiKanan < -1f) {
                tamatchi.jarak *= -1;
            }

            tamatchi.limitKakiKiri += tamatchi.jarak;
            tamatchi.limitKakiKanan += tamatchi.jarak;
            tamatchi.objectsSphere.get(6).rotateObject((float) Math.toRadians(tamatchi.limitKakiKiri), 1.0f, 0.0f, 0.0f);
            tamatchi.objectsSphere.get(7).rotateObject((float) Math.toRadians(tamatchi.limitKakiKanan), -1.0f, 0.0f, 0.0f);
        }

        if(window.isKeyPressed(GLFW_KEY_Z)) {
            for (Sphere sphere:  wawatchi.objectsSphere){
                sphere.scaleObject(0.997f,0.997f,0.997f);
            }
            for (Torus torus:  wawatchi.objectTorus){
                torus.scaleObject(0.997f,0.997f,0.997f);
            }
            for (Sphere sphere:  wawatchi.objectsLuar){
                sphere.scaleObject(0.997f,0.997f,0.997f);
            }
            for (Object bezier:  wawatchi.titikBezier){
                bezier.scaleObject(0.997f,0.997f,0.997f);
            }
            for (Object bezier:  wawatchi.titikBezier2){
                bezier.scaleObject(0.997f,0.997f,0.997f);
            }
        }
        if(window.isKeyPressed(GLFW_KEY_X))
        {
            for (Sphere sphere:  wawatchi.objectsSphere){
                sphere.scaleObject(1.001f,1.001f,1.001f);
            }
            for (Torus torus:  wawatchi.objectTorus){
                torus.scaleObject(1.001f,1.001f,1.0f);
            }
            for (Sphere sphere:  wawatchi.objectsLuar){
                sphere.scaleObject(1.001f,1.001f,1.001f);
            }
            for (Object bezier:  wawatchi.titikBezier){
                bezier.scaleObject(1.001f,1.001f,1.001f);
            }
            for (Object bezier:  wawatchi.titikBezier2){
                bezier.scaleObject(1.001f,1.001f,1.001f);
            }
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT)){
            gambarSekarang = 0;
            gantiGambar = true;
        } else if (window.isKeyPressed(GLFW_KEY_UP)){
            gambarSekarang = 1;
            gantiGambar = true;
        } else if (window.isKeyPressed(GLFW_KEY_RIGHT)){
            gambarSekarang = 2;
            gantiGambar = true;
        } else if (window.isKeyPressed(GLFW_KEY_DOWN)){
            gambarSekarang = 3;
            gantiGambar = true;
        }

        // Gerak Tangan Naik Turun
        if (window.isKeyPressed(GLFW_KEY_1)){
            wawatchi.gerakTangan();
        }

        // Gerak kaki maju mundur
        if (window.isKeyPressed(GLFW_KEY_2)){
            wawatchi.gerakKaki();
        }

        // Gerak kaki kiri kanan
        if (window.isKeyPressed(GLFW_KEY_3)){
            wawatchi.gerakKakiKananKiri();
        }

        if (window.isKeyPressed(GLFW_KEY_4)){
            wawatchi.gerakMaju();
            wawatchi.gerakTangan();
        }

        if (window.isKeyPressed(GLFW_KEY_H)){
            wawatchi.gerakKanan = true;
        }

        if ( wawatchi.gerakKanan){
            wawatchi.timeGerakKanan += 0.001f;
        }

        if ( wawatchi.timeGerakKanan >= 0.14f){
            wawatchi.gerakKanan = false;
            wawatchi.gerakKiri = true;
            wawatchi.timeGerakKanan = 0;
        }

        if ( wawatchi.gerakKiri){
            wawatchi.timeGerakKiri += 0.001f;
        }

        if ( wawatchi.timeGerakKiri >= 0.28f){
            wawatchi.gerakKiri = false;
            wawatchi.gerakKanan2 = true;
            wawatchi.timeGerakKiri = 0;
        }

        if ( wawatchi.gerakKanan2){
            wawatchi.timeGerakKanan2 += 0.001f;
        }

        if ( wawatchi.timeGerakKanan2 >= 0.28f){
            wawatchi.gerakKanan2 = false;
            wawatchi.gerakKiri = true;
            wawatchi.timeGerakKanan2 =0;
        }

        if (window.isKeyPressed(GLFW_KEY_Y)){
            wawatchi.gerakKiri = false;
            wawatchi.gerakKanan = false;
            wawatchi.gerakKanan2 = false;
            wawatchi.gerakKiriInfinite = false;
            wawatchi.gerakKananInfinite = false;
        }

        if (window.isKeyPressed(GLFW_KEY_M)){
            wawatchi.gerakKananInfinite = true;
            wawatchi.gerakKiriInfinite = false;
        }
        if(window.isKeyPressed(GLFW_KEY_N)){
            wawatchi.gerakKiriInfinite = true;
            wawatchi.gerakKananInfinite = false;
        }

        if (window.isKeyPressed(GLFW_KEY_SPACE)) {
            wawatchi.isJumping = true;
            tamatchi.goingUp = true;
        }

        if (tamatchi.goingUp) {
            tamatchi.limit += 0.0008f;
            System.out.println(tamatchi.limit);
        }

        if (tamatchi.limit >= 0.18f) {
            tamatchi.goingUp = false;
            tamatchi.goingDown = true;
        }

        if (tamatchi.goingDown) {
            tamatchi.limit -= 0.0008f;
            System.out.println(tamatchi.limit);
        }

        if (tamatchi.limit <= 0.0008f) {
            tamatchi.goingDown = false;
        }

        if ( wawatchi.isJumping) {
            wawatchi.y += 0.0008f;
        }

        if ( wawatchi.y >= 0.18f){
            wawatchi.isJumping = false;
            wawatchi.isFalling = true;
        }

        if ( wawatchi.isFalling){
            wawatchi.y-= 0.001f;
        }
        if ( wawatchi.y <= 0.0f){
            wawatchi.isFalling = false;
        }

        if (window.isKeyPressed(GLFW_KEY_ENTER)){
            wawatchi.toTheMoon = true;
        }

        if ( wawatchi.toTheMoon){
            wawatchi.yToTheMoon += 0.001f;
            if ( wawatchi.yToTheMoon > 0.4f) {
                wawatchi.toTheMoon = false;
            }
        }

    }


    public void loop() {
        while (window.isOpen()) {
            window.update();
            // ini untuk background colornya
            glClearColor(0.0f, 1.0f, 0.5f, 1.0f); // direset, tapi hanya 1 frame maka perlu diloop
            GL.createCapabilities();
            input();
            // code di bawah createcapabilities dan di atas restore state
            if (gambarSekarang == 0){
                if (gantiGambar){
                    wawatchi.objectsSphere.clear();
                    wawatchi.objectTorus.clear();
                    wawatchi.objectsLuar.clear();
                    wawatchi.titikBezier.clear();
                    wawatchi.titikBezier2.clear();
                    wawatchi.init();
                    tamatchi.objectsSphere.clear();
                    tamatchi.titikBerzier.clear();
                    tamatchi.titikBerzier2.clear();
                    tamatchi.titikBerzier3.clear();
                    tamatchi.titikBerzier4.clear();
                    tamatchi.titikBerzier5.clear();
                    tamatchi.titikBerzier6.clear();
                    tamatchi.init();
                    hikotchi.objectsSphere.clear();
                    hikotchi.titikBerzier.clear();
                    hikotchi.titikBerzier1.clear();
                    hikotchi.titikBerzier2.clear();
                    hikotchi.titikBerzier3.clear();
                    hikotchi.titikBerzier4.clear();
                    hikotchi.init();
                    wawatchi.translateObject(0.0f, -0.5f, 0.0f);
                    tamatchi.translateObject(0.5f, 0.2f, 0.0f);
                    hikotchi.translateObject(-0.4f, 0.1f, 0.0f);
                    gantiGambar = false;
                }

                wawatchi.loop();
                tamatchi.loop();
                hikotchi.loop();

            } else if (gambarSekarang == 1){
                if (gantiGambar) {
                    wawatchi.objectsSphere.clear();
                    wawatchi.objectTorus.clear();
                    wawatchi.objectsLuar.clear();
                    wawatchi.titikBezier.clear();
                    wawatchi.titikBezier2.clear();
                    wawatchi.init();
                    gantiGambar = false;
                }
                wawatchi.loop();
            } else if (gambarSekarang == 2){
                if (gantiGambar) {
                    tamatchi.objectsSphere.clear();
                    tamatchi.titikBerzier.clear();
                    tamatchi.titikBerzier2.clear();
                    tamatchi.titikBerzier3.clear();
                    tamatchi.titikBerzier4.clear();
                    tamatchi.titikBerzier5.clear();
                    tamatchi.titikBerzier6.clear();
                    tamatchi.init();
                    gantiGambar = false;
                }
                tamatchi.loop();
            } else if (gambarSekarang == 3){
                if (gantiGambar) {
                    hikotchi.objectsSphere.clear();
                    hikotchi.titikBerzier.clear();
                    hikotchi.titikBerzier1.clear();
                    hikotchi.titikBerzier2.clear();
                    hikotchi.titikBerzier3.clear();
                    hikotchi.titikBerzier4.clear();
                    hikotchi.init();
                    gantiGambar = false;
                }
                hikotchi.loop();
            }

            // restore state
            glDisableVertexAttribArray(0);
            // poll fow window events
            // the key callback above will only be invoked during this call
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}