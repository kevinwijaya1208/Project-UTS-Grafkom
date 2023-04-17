package Engine;

import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL30.*;

// Class Hikotchi = Nathan Erens Anderson / c14210121
public class Hikotchi {
    public ArrayList<Object> titikBerzier = new ArrayList<>();
    public ArrayList<Object> titikBerzier1 = new ArrayList<>();
    public ArrayList<Object> titikBerzier2 = new ArrayList<>();
    public ArrayList<Object> titikBerzier3 = new ArrayList<>();
    public ArrayList<Object> titikBerzier4 = new ArrayList<>();

    public ArrayList<Sphere> objectsSphere = new ArrayList<>();


    private static float[][] rambut1 = {
            {0.048f, 0.466f},
            {0.252f, 0.682f},
            {0.024f, 0.754f}
    };

    private static float[][] rambut2 = {
            {0.112f, 0.454f},
            {0.228f, 0.62f},
            {0.396f, 0.376f}
    };

    private static float[][] rambut3 = {
            {0.008f, 0.456f},
            {-0.176f, 0.72f},
            {0.166f, 0.71f},
            {-0.02f, 0.888f}
    };

    private static float[][] rambut4 = {
            {0.028f, 0.448f},
            {0.76f, 0.724f},
            {-0.036f, 0.814f},
            {0.51f, -0.334f}
    };

    private static float[][] rambut5 = {
            {-0.01f, 0.432f},
            {-0.786f, 0.508f},
            {-0.384f, 0.718f},
            {-0.482f, 0.11f},
            {-0.148f, 0.826f}
    };

    public void init(){
        titikBerzier.add(new Object(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f) // ini untuk warna garisnya
        ));
        berzier2d(rambut1, 1);


        titikBerzier1.add(new Object(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f) // ini untuk warna garisnya
        ));
        berzier2d(rambut2, 2);

        titikBerzier2.add(new Object(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f) // ini untuk warna garisnya
        ));
        berzier2d(rambut3, 3);

        titikBerzier3.add(new Object(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f) // ini untuk warna garisnya
        ));
        berzier2d(rambut4, 4);

        titikBerzier4.add(new Object(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f) // ini untuk warna garisnya
        ));
        berzier2d(rambut5, 5);

        // badan
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 0f, 0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.5f, 0.5f,
                0.4f, 0.4f, 0.4f, 1
        ));
        objectsSphere.get(0).scaleObject(0.6f, 0.6f, 0.6f);
        objectsSphere.get(0).translateObject(0.0f, 0.27f, 0.0f);

        // kaki kiri
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 0f, 1.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.5f, 0.5f,
                0.4f, 0.4f, 0.4f, 7
        ));
        objectsSphere.get(1).scaleObject(0.3f, 0.15f, 0.3f);
        objectsSphere.get(1).translateObject(-0.23f, 0.17f, 0.0f);

        //kaki kanan
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 0f, 1.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.5f, 0.5f,
                0.4f, 0.4f, 0.4f, 7
        ));
        objectsSphere.get(2).scaleObject(0.3f, 0.15f, 0.3f);
        objectsSphere.get(2).translateObject(0.23f, 0.17f, 0.0f);


        //kaki tengah
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 0f, 1.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.5f, 0.5f,
                0.4f, 0.4f, 0.4f, 7
        ));
        objectsSphere.get(3).scaleObject(0.3f, 0.15f, 0.3f);
        objectsSphere.get(3).translateObject(0f, 0.07f, 0.0f);

        //mulut
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 1.0f, 0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.5f, 0.5f,
                0.4f, 0.1f, 0.4f, 12
        ));
        objectsSphere.get(4).scaleObject(0.3f, 0.2f, 0.3f);
        objectsSphere.get(4).translateObject(-0.04f, 0.3f, -0.44f);

        //mata kiri
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0f, 0f, 0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.5f, 0.5f,
                0.1f, 0.1f, 0.1f, 12
        ));
        objectsSphere.get(5).scaleObject(0.25f, 0.25f, 0.06f);
        objectsSphere.get(5).translateObject(-0.14f, 0.42f, -0.246f);

        //mata kanan
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0f, 0f, 0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.5f, 0.5f,
                0.1f, 0.1f, 0.1f, 12
        ));
        objectsSphere.get(6).scaleObject(0.25f, 0.25f, 0.06f);
        objectsSphere.get(6).translateObject(0.1f, 0.33f, -0.29f);

        //kerucut tengah
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0f, 0f, 0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.5f, 0.5f,
                0.1f, 0.1f, 0.1f, 9
        ));
        objectsSphere.get(7).scaleObject(0.3f, 0.3f, 0.3f);
        objectsSphere.get(7).rotateObject((float) Math.toRadians(90), 1f, 0f, 0f);
        objectsSphere.get(7).translateObject(0f, -0.17f, 0f);

        //kerucut kanan
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0f, 0f, 0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.5f, 0.5f,
                0.1f, 0.1f, 0.1f, 9
        ));
        objectsSphere.get(8).scaleObject(0.3f, 0.3f, 0.3f);
        objectsSphere.get(8).rotateObject((float) Math.toRadians(90), 1f, 0f, 0f);
        objectsSphere.get(8).translateObject(0.23f, -0.08f, 0f);

        //kerucut kiri
        objectsSphere.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0f, 0f, 0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.5f, 0.5f,
                0.1f, 0.1f, 0.1f, 9
        ));
        objectsSphere.get(9).scaleObject(0.3f, 0.3f, 0.3f);
        objectsSphere.get(9).rotateObject((float) Math.toRadians(90), 1f, 0f, 0f);
        objectsSphere.get(9).translateObject(-0.23f, -0.08f, 0f);

        objectsSphere.get(0).getChildObject().add(titikBerzier.get(0));
        objectsSphere.get(0).getChildObject().add(titikBerzier1.get(0));
        objectsSphere.get(0).getChildObject().add(titikBerzier2.get(0));
        objectsSphere.get(0).getChildObject().add(titikBerzier3.get(0));
        objectsSphere.get(0).getChildObject().add(titikBerzier4.get(0));
    }
    public void rotateObject(float degree, float x, float y, float z) {
        for (Object object: objectsSphere){
            object.rotateObject((float)Math.toRadians(degree), x, y ,z);
        }
    }


    public void scaleObject(float scaleX, float scaleY, float scaleZ) {
        for (Object object: objectsSphere){
            object.scaleObject(scaleX, scaleY ,scaleZ);
        }
        for (Object object: titikBerzier){
            object.scaleObject(scaleX, scaleY, scaleZ);
        }
        for (Object object: titikBerzier1){
            object.scaleObject(scaleX, scaleY, scaleZ);
        }
        for (Object object: titikBerzier2){
            object.scaleObject(scaleX, scaleY, scaleZ);
        }
        for (Object object: titikBerzier3){
            object.scaleObject(scaleX, scaleY, scaleZ);
        }
        for (Object object: titikBerzier4){
            object.scaleObject(scaleX, scaleY, scaleZ);
        }
    }

    public void translateObject(float x, float y, float z) {
        for (Object object: objectsSphere){
            object.translateObject(x,y,z);
        }
    }

    public void berzier2d(float[][] floats, int pilihan) {
        int indexBerzier = 0;
        for (float t = 0; t <= 1; t += 0.01f) {
            float x = 0;
            float y = 0;
            int n = floats.length - 1;
            for (int i = 0; i <= n; i++) {
                int koefisien = koefSegitigaPascal(n, i);
                float term = koefisien * (float) Math.pow(1 - t, n - i) * (float) Math.pow(t, i);
                x += term * floats[i][0];
                y += term * floats[i][1];

            }
            if (pilihan == 1) {
                titikBerzier.get(0).addVertices(new Vector3f(x, y, 0));
            }
            if (pilihan == 2) {
                titikBerzier1.get(0).addVertices(new Vector3f(x, y, 0));
            }
            if (pilihan == 3) {
                titikBerzier2.get(0).addVertices(new Vector3f(x, y, 0));
            }
            if (pilihan == 4) {
                titikBerzier3.get(0).addVertices(new Vector3f(x, y, 0));
            }
            if (pilihan == 5) {
                titikBerzier4.get(0).addVertices(new Vector3f(x, y, 0));
            }


        }
    }

    public int koefSegitigaPascal(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        int koef = 1;
        for (int i = 0; i < k; i++) {
            koef *= (n - i);
            koef /= (i + 1);
        }
        return koef;
    }

    public void loop(){
        for (Object object : objectsSphere) {
            object.draw();
        }
        for (Object object : titikBerzier) {
            object.drawLineBerzier();
        }
        for (Object object : titikBerzier1) {
            object.drawLineBerzier();
        }
        for (Object object : titikBerzier2) {
            object.drawLineBerzier();
        }
        for (Object object : titikBerzier3) {
            object.drawLineBerzier();
        }
        for (Object object : titikBerzier4) {
            object.drawLineBerzier();
        }
    }
}
