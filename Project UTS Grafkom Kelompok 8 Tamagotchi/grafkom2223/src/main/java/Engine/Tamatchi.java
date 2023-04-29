package Engine;

import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

// Class Tamatchi = Gabriel Evan Delwyn / c14210190
public class Tamatchi {
    Camera camera;
    Projection projection;

    public ArrayList<Object> titikBerzier = new ArrayList<>();

    public ArrayList<Object> titikBerzier2 = new ArrayList<>();

    public ArrayList<Object> titikBerzier3 = new ArrayList<>();

    public ArrayList<Object> titikBerzier4 = new ArrayList<>();

    public ArrayList<Object> titikBerzier5 = new ArrayList<>();

    public ArrayList<Object> titikBerzier6 = new ArrayList<>();

    public ArrayList<Sphere> objectsSphere = new ArrayList<>();
    public boolean goingUp, goingDown;
    public float limit;
    public int tes;
    public float limitKakiKiri = 0.0001f;
    public float limitKakiKanan = -0.0001f;
    public float jarak = 0.0001f;
    private static float[][] controlPointsBlushKiri1 = {
            {-0.22f, 0.278f, 0.19f},
            {-0.238f, 0.23f, 0.19f}
    };
    private static float[][] controlPointsBlushKiri2 = {
            {-0.2f, 0.272f, 0.19f},
            {-0.212f, 0.228f, 0.19f}
    };
    private static float[][] controlPointsBlushKiri3 = {
            {-0.18f, 0.268f, 0.19f},
            {-0.184f, 0.226f, 0.19f}
    };
    private static float[][] controlPointsBlushKanan1 = {
            {0.176f, 0.27f, 0.19f},
            {0.168f, 0.228f, 0.19f}
    };
    private static float[][] controlPointsBlushKanan2 = {
            {0.202f, 0.266f, 0.19f},
            {0.2f, 0.224f, 0.19f}
    };

    private static float[][] controlPointsBlushKanan3 = {
            {0.238f, 0.264f, 0.19f},
            {0.23f, 0.226f, 0.19f}
    };

    public Tamatchi(Camera camera, Projection projection){
        this.camera = camera;
        this.projection = projection;
    }

    public void init(){
        titikBerzier.add(new Object(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0.956f, 0.76f, 0.76f, 1.0f) // ini untuk warna garisnya
        ));

        titikBerzier2.add(new Object(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0.956f, 0.76f, 0.76f, 1.0f) // ini untuk warna garisnya
        ));

        titikBerzier3.add(new Object(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0.956f, 0.76f, 0.76f, 1.0f) // ini untuk warna garisnya
        ));

        titikBerzier4.add(new Object(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0.956f, 0.76f, 0.76f, 1.0f) // ini untuk warna garisnya
        ));

        titikBerzier5.add(new Object(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0.956f, 0.76f, 0.76f, 1.0f) // ini untuk warna garisnya
        ));

        titikBerzier6.add(new Object(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0.956f, 0.76f, 0.76f, 1.0f) // ini untuk warna garisnya
        ));

        //Body
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
        ), new Vector4f(0.913f, 0.066f, 0.56f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f,
                0.4f, 0.45f, 0.2f, 12
        ));
        objectsSphere.get(0).scaleObject(0.67f, 0.72f, 0.4f);
        objectsSphere.get(0).translateObject(0.0f, 0.27f, 0.0f);
        objectsSphere.get(0).setCenterx(0.0f);

        //Left Eye
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                -0.1f, 0.37f, 0.0f,
                0.03f, 0.03f, 0.2f, 1
        ));
        objectsSphere.get(1).scaleObject(0.06f, 0.06f, 0.03f);
        objectsSphere.get(1).translateObject(-0.15f, 0.36f, 0.17f);
        objectsSphere.get(0).getChildObject().add(objectsSphere.get(1));

        //Right Eye
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                0.1f, 0.37f, 0.0f,
                0.03f, 0.03f, 0.2f, 1
        ));
        objectsSphere.get(2).scaleObject(0.06f, 0.06f, 0.03f);
        objectsSphere.get(2).translateObject(0.15f, 0.36f, 0.17f);
        objectsSphere.get(0).getChildObject().add(objectsSphere.get(2));

        //Mouth
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.37f, 0.0f,
                0.3f, 0.3f, 0.2f, 7
        ));
        objectsSphere.get(3).scaleObject(0.5f, 0.08f, 0.14f);
        objectsSphere.get(3).translateObject(0.0f, -0.15f, 0.2f);
        objectsSphere.get(3).rotateObject((float) Math.toRadians(-90), 1.0f, 0.0f, 0.0f); //rotate 90 jadi o mulutnya trs offset translate jd 0.5
        objectsSphere.get(0).getChildObject().add(objectsSphere.get(3));


        //Left Hand
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
        ), new Vector4f(0.913f, 0.066f, 0.56f, 1.0f),
                0.0f, 1.0f, 0.0f,
                0.3f, 0.2f, 0.2f, 12
        ));
        objectsSphere.get(4).scaleObject(0.5f, 0.5f, 0.4f);
        objectsSphere.get(4).translateObject(-0.65f, 0.5f, 0.0f);
        objectsSphere.get(4).rotateObject((float) Math.toRadians(270), -0.5f, 0.35f, 0.0f);
        objectsSphere.get(0).getChildObject().add(objectsSphere.get(4));

        //Right Hand
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
        ), new Vector4f(0.913f, 0.066f, 0.56f, 1.0f), 0.0f, 1.0f, 0.0f,
                0.3f, 0.2f, 0.2f, 12
        ));
        objectsSphere.get(5).scaleObject(0.5f, 0.5f, 0.4f);
        objectsSphere.get(5).translateObject(0.65f, 0.5f, 0.0f);
        objectsSphere.get(5).rotateObject((float) Math.toRadians(90), 0.5f, 0.35f, 0.0f);
        objectsSphere.get(0).getChildObject().add(objectsSphere.get(5));

        //Left Foot
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
        ), new Vector4f(0.913f, 0.066f, 0.56f, 1.0f), // ini untuk warna object
                0.3f, 0.2f, 0.2f,
                0.3f, 0.3f, 0.2f, 12
        ));
        objectsSphere.get(6).scaleObject(0.5f, 0.5f, 0.4f);
        objectsSphere.get(6).translateObject(-0.4f, 0.0f, 0.0f);
        objectsSphere.get(6).rotateObject((float) Math.toRadians(90), 0.5f, 0.0f, 0.0f);
        objectsSphere.get(0).getChildObject().add(objectsSphere.get(6));

        //Right Foot
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
        ), new Vector4f(0.913f, 0.066f, 0.56f, 1.0f), // ini untuk warna object
                0.3f, 0.2f, 0.2f,
                0.3f, 0.3f, 0.2f, 12
        ));
        objectsSphere.get(7).scaleObject(0.5f, 0.5f, 0.4f);
        objectsSphere.get(7).translateObject(0.4f, 0.0f, 0.0f);
        objectsSphere.get(7).rotateObject((float) Math.toRadians(270), 0.5f, 0.0f, 0.0f);
        objectsSphere.get(0).getChildObject().add(objectsSphere.get(7));

        //Right Blush
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
        ), new Vector4f(1.0f, 0.713f, 0.756f, 1.0f), // ini untuk warna object
                0.1f, 0.3f, 0.0f,
                0.03f, 0.02f, 0.2f, 1
        ));
        objectsSphere.get(8).scaleObject(0.1f, 0.03f, 0.03f);
        objectsSphere.get(8).translateObject(0.2f, 0.25f, 0.18f);
        objectsSphere.get(0).getChildObject().add(objectsSphere.get(8));

        //Left Blush
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
        ), new Vector4f(1.0f, 0.713f, 0.756f, 1.0f), // ini untuk warna object
                -0.1f, 0.3f, 0.0f,
                0.03f, 0.02f, 0.2f, 1
        ));
        objectsSphere.get(9).scaleObject(0.1f, 0.03f, 0.03f);
        objectsSphere.get(9).translateObject(-0.2f, 0.25f, 0.18f);
        objectsSphere.get(0).getChildObject().add(objectsSphere.get(9));

        //Blush Line Berzier Curve
        berzierBlush(controlPointsBlushKiri1, 0);
        objectsSphere.get(0).getChildObject().add(titikBerzier.get(0));
        berzierBlush(controlPointsBlushKiri2, 1);
        objectsSphere.get(0).getChildObject().add(titikBerzier2.get(0));
        berzierBlush(controlPointsBlushKiri3, 2);
        objectsSphere.get(0).getChildObject().add(titikBerzier3.get(0));
        berzierBlush(controlPointsBlushKanan1, 3);
        objectsSphere.get(0).getChildObject().add(titikBerzier4.get(0));
        berzierBlush(controlPointsBlushKanan2, 4);
        objectsSphere.get(0).getChildObject().add(titikBerzier5.get(0));
        berzierBlush(controlPointsBlushKanan3, 5);
        objectsSphere.get(0).getChildObject().add(titikBerzier6.get(0));
    }

    public void rotateObject(float degree, float x, float y, float z) {
        objectsSphere.get(0).rotateObject((float)Math.toRadians(degree), x, y ,z);
    }


    public void scaleObject(float scaleX, float scaleY, float scaleZ) {
        for (Sphere sphere:  objectsSphere){
            sphere.scaleObject(scaleX, scaleY, scaleZ);
        }
        for (Object object: titikBerzier){
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
        for (Object object: titikBerzier5){
            object.scaleObject(scaleX, scaleY, scaleZ);
        }
        for (Object object: titikBerzier6){
            object.scaleObject(scaleX, scaleY, scaleZ);
        }
    }

    public void translateObject(float x, float y, float z) {
        objectsSphere.get(0).translateObject(x,y,z);
    }

    public void berzierBlush(float[][] floats, int pilihan) {
        int indexBerzier = 0;
        for (float t = 0; t <= 1; t += 0.01f) {
            float x = 0;
            float y = 0;
            float z = 0;
            int n = floats.length - 1;
            for (int i = 0; i <= n; i++) {
                int koefisien = koefSegitigaPascal(n, i);
                float term = koefisien * (float) Math.pow(1 - t, n - i) * (float) Math.pow(t, i);
                x += term * floats[i][0];
                y += term * floats[i][1];
                z += term * floats[i][2];
            }
            if (tes == 0) {
                if (pilihan == 0) {
                    titikBerzier.get(0).addVertices(new Vector3f(x, y, z));
                } else if (pilihan == 1) {
                    titikBerzier2.get(0).addVertices(new Vector3f(x, y, z));
                } else if (pilihan == 2) {
                    titikBerzier3.get(0).addVertices(new Vector3f(x, y, z));
                } else if (pilihan == 3) {
                    titikBerzier4.get(0).addVertices(new Vector3f(x, y, z));
                } else if (pilihan == 4) {
                    titikBerzier5.get(0).addVertices(new Vector3f(x, y, z));
                } else if (pilihan == 5) {
                    titikBerzier6.get(0).addVertices(new Vector3f(x, y, z));
                }
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
        if (goingUp) {
            objectsSphere.get(0).translateObject(0.0f, 0.0035f, 0.0f);
        }

        if (goingDown) {
            objectsSphere.get(0).translateObject(0.0f, -0.0035f, 0.0f);
        }
        // code di bawah createcapabilities dan di atas restore state
        for (Object object : objectsSphere) {
            object.draw(camera, projection);
        }

        for (Object object : titikBerzier) {
            object.drawLineBerzier(camera, projection);
        }

        for (Object object : titikBerzier2) {
            object.drawLineBerzier(camera, projection);
        }

        for (Object object : titikBerzier3) {
            object.drawLineBerzier(camera, projection);
        }

        for (Object object : titikBerzier4) {
            object.drawLineBerzier(camera, projection);
        }

        for (Object object : titikBerzier5) {
            object.drawLineBerzier(camera, projection);
        }

        for (Object object : titikBerzier6) {
            object.drawLineBerzier(camera, projection);
        }
    }
}
