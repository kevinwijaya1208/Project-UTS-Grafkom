package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

// Gabriel Evan Delwyn - c14210190
public class Bangunan2 {
    Camera camera;
    Projection projection;
    public boolean curve;
    public ArrayList<Object> titikBezier = new ArrayList<>();
    public ArrayList<Sphere> objectsBangunan = new ArrayList<>();

    private static float[][] controlPointsPintu = {
            {-0.002f, -0.063f, 0.22f},
            {-0.002f, -0.161f, 0.22f}
    };

    public Bangunan2(Camera camera, Projection projection){
        this.camera = camera;
        this.projection = projection;
    }

    public void init(){
        titikBezier.add(new Object(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.54f, 1.0f) // ini untuk warna garisnya
        ));

        //Bun
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 0.64f, 0.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 11
        ));
        objectsBangunan.get(0).scaleObject(1.0f, 1.0f, 0.8f);
        objectsBangunan.get(0).rotateObject((float)Math.toRadians(90), 1.0f, 0.0f, 0.0f);

        //Patty
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.54f, 0.25f, 0.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 11
        ));
        objectsBangunan.get(1).scaleObject(1.0f, 1.0f, 0.3f);
        objectsBangunan.get(1).rotateObject((float)Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        objectsBangunan.get(1).translateObject(0.0f, 0.05f, 0.0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(1));

        //Bun
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 0.64f, 0.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 11
        ));
        objectsBangunan.get(2).scaleObject(1.0f, 1.0f, 0.8f);
        objectsBangunan.get(2).rotateObject((float)Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        objectsBangunan.get(2).translateObject(0.0f, 0.2f, 0.0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(2));

        //Egg
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 11
        ));
        objectsBangunan.get(3).scaleObject(1.0f, 1.0f, 0.1f);
        objectsBangunan.get(3).rotateObject((float)Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        objectsBangunan.get(3).translateObject(0.0f, 0.22f, 0.0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(3));

        //Sayur
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.30f, 0.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 11
        ));
        objectsBangunan.get(4).scaleObject(1.0f, 1.0f, 0.1f);
        objectsBangunan.get(4).rotateObject((float)Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        objectsBangunan.get(4).translateObject(0.0f, 0.24f, 0.0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(4));

        //Bun lagi
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 0.64f, 0.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 11
        ));
        objectsBangunan.get(5).scaleObject(1.0f, 1.0f, 0.8f);
        objectsBangunan.get(5).rotateObject((float)Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        objectsBangunan.get(5).translateObject(0.0f, 0.4f, 0.0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(5));

        //Patty lagi
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.54f, 0.25f, 0.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 11
        ));
        objectsBangunan.get(6).scaleObject(1.0f, 1.0f, 0.3f);
        objectsBangunan.get(6).rotateObject((float)Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        objectsBangunan.get(6).translateObject(0.0f, 0.45f, 0.0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(6));

        //Sayur lagi
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.30f, 0.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 11
        ));
        objectsBangunan.get(7).scaleObject(1.0f, 1.0f, 0.1f);
        objectsBangunan.get(7).rotateObject((float)Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        objectsBangunan.get(7).translateObject(0.0f, 0.47f, 0.0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(7));

        //Bun terakhir
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 0.64f, 0.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 2
        ));
        objectsBangunan.get(8).scaleObject(0.83f, 0.5f, 0.38f);
        objectsBangunan.get(8).translateObject(0.0f, 0.48f, 0.0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(8));

        //jendela
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.0f, 0.5f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 1
        ));
        objectsBangunan.get(9).scaleObject(0.1f, 0.1f, 0.1f);
        objectsBangunan.get(9).translateObject(0.23f, 0.11f, 0.13f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(9));

        //jendela lagi
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.0f, 0.5f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 1
        ));
        objectsBangunan.get(10).scaleObject(0.1f, 0.1f, 0.1f);
        objectsBangunan.get(10).translateObject(0.0f, 0.11f, 0.17f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(10));

        //jendela lagi 2
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.0f, 0.5f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 1
        ));
        objectsBangunan.get(11).scaleObject(0.1f, 0.1f, 0.1f);
        objectsBangunan.get(11).translateObject(-0.23f, 0.11f, 0.13f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(11));

        //jendela lagi 3
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.0f, 0.5f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 1
        ));
        objectsBangunan.get(12).scaleObject(0.1f, 0.1f, 0.1f);
        objectsBangunan.get(12).translateObject(0.23f, 0.32f, 0.13f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(12));

        //jendela lagi 4
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.0f, 0.5f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 1
        ));
        objectsBangunan.get(13).scaleObject(0.1f, 0.1f, 0.1f);
        objectsBangunan.get(13).translateObject(-0.23f, 0.32f, 0.13f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(13));

        //jendela lagi lolo
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.0f, 0.5f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 1
        ));
        objectsBangunan.get(14).scaleObject(0.1f, 0.1f, 0.1f);
        objectsBangunan.get(14).translateObject(0.0f, 0.32f, 0.17f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(14));

        //jendelas
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.0f, 0.5f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 1
        ));
        objectsBangunan.get(15).scaleObject(0.1f, 0.1f, 0.1f);
        objectsBangunan.get(15).translateObject(-0.23f, -0.07f, 0.13f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(15));

        //jendelaa
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.0f, 0.0f, 0.5f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 1
        ));
        objectsBangunan.get(16).scaleObject(0.1f, 0.1f, 0.1f);
        objectsBangunan.get(16).translateObject(0.23f, -0.07f, 0.13f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(16));

        //mata
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.1f, 0.1f, 0.2f, 1
        ));
        objectsBangunan.get(17).scaleObject(0.05f, 0.12f, 0.1f);
        objectsBangunan.get(17).rotateObject((float)Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsBangunan.get(17).translateObject(0.12f, 0.6f, 0.17f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(17));

        //mata2
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.1f, 0.1f, 0.2f, 1
        ));
        objectsBangunan.get(18).scaleObject(0.05f, 0.12f, 0.1f);
        objectsBangunan.get(18).rotateObject((float)Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsBangunan.get(18).translateObject(-0.12f, 0.6f, 0.17f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(18));

        //pupil
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.675f, 0.847f, 0.9f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.1f, 0.1f, 0.2f, 1
        ));
        objectsBangunan.get(19).scaleObject(0.05f, 0.05f, 0.05f);
        objectsBangunan.get(19).rotateObject((float)Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsBangunan.get(19).translateObject(0.12f, 0.57f, 0.18f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(19));

        //pupils
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.675f, 0.847f, 0.9f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.1f, 0.1f, 0.2f, 1
        ));
        objectsBangunan.get(20).scaleObject(0.05f, 0.05f, 0.05f);
        objectsBangunan.get(20).rotateObject((float)Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsBangunan.get(20).translateObject(-0.12f, 0.57f, 0.18f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(20));

        //pintu
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(0.675f, 0.847f, 0.9f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 3
        ));
        objectsBangunan.get(21).scaleObject(0.4f, 0.5f, 0.08f);
        objectsBangunan.get(21).translateObject(0.0f, -0.11f, 0.21f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(21));

        //jerawat
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.1f, 0.1f, 0.2f, 1
        ));
        objectsBangunan.get(22).scaleObject(0.01f, 0.01f, 0.01f);
        objectsBangunan.get(22).rotateObject((float)Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsBangunan.get(22).translateObject(-0.2f, 0.5f, 0.17f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(22));

        //jerawat
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.1f, 0.1f, 0.2f, 1
        ));
        objectsBangunan.get(23).scaleObject(0.01f, 0.01f, 0.01f);
        objectsBangunan.get(23).rotateObject((float)Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsBangunan.get(23).translateObject(-0.23f, 0.5f, 0.16f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(23));

        //jerawat
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.1f, 0.1f, 0.2f, 1
        ));
        objectsBangunan.get(24).scaleObject(0.01f, 0.01f, 0.01f);
        objectsBangunan.get(24).rotateObject((float)Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsBangunan.get(24).translateObject(-0.215f, 0.51f, 0.16f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(24));

        //jerawat
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.1f, 0.1f, 0.2f, 1
        ));
        objectsBangunan.get(25).scaleObject(0.01f, 0.01f, 0.01f);
        objectsBangunan.get(25).rotateObject((float)Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsBangunan.get(25).translateObject(0.2f, 0.5f, 0.17f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(25));

        //jerawat
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.1f, 0.1f, 0.2f, 1
        ));
        objectsBangunan.get(26).scaleObject(0.01f, 0.01f, 0.01f);
        objectsBangunan.get(26).rotateObject((float)Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsBangunan.get(26).translateObject(0.23f, 0.5f, 0.16f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(26));

        //jerawat
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.1f, 0.1f, 0.2f, 1
        ));
        objectsBangunan.get(27).scaleObject(0.01f, 0.01f, 0.01f);
        objectsBangunan.get(27).rotateObject((float)Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsBangunan.get(27).translateObject(0.215f, 0.51f, 0.16f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(27));

        //Mulut
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 1.0f, 0.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 3
        ));
        objectsBangunan.get(28).scaleObject(0.25f, 0.1f, 0.1f);
        objectsBangunan.get(28).translateObject(0.0f, 0.525f, 0.2f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(28));

        //Mulut2
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 1.0f, 0.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 3
        ));
        objectsBangunan.get(29).scaleObject(0.25f, 0.1f, 0.1f);
        objectsBangunan.get(29).translateObject(0.0f, 0.48f, 0.2f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(29));

        //Mulut3
        objectsBangunan.add(new Sphere(Arrays.asList(
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
        ), new ArrayList<>(
                List.of(
                        new Vector3f(-0.5f, 0.5f, 0.0f),
                        new Vector3f(-0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, -0.5f, 0.0f),
                        new Vector3f(0.5f, 0.5f, 0.0f)
                )
        ), new Vector4f(1.0f, 1.0f, 0.0f, 1.0f), // ini untuk warna object segitiganya
                0.0f, 0.0f, 0.0f, 0.4f, 0.2f, 0.2f, 3
        ));
        objectsBangunan.get(30).scaleObject(0.16f, 0.1f, 0.1f);
        objectsBangunan.get(30).rotateObject((float)Math.toRadians(90), 0.0f, 0.0f, 1.0f);
        objectsBangunan.get(30).translateObject(0.045f, 0.503f, 0.2f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(30));
        bezier(controlPointsPintu, 0);
        objectsBangunan.get(0).getChildObject().add(titikBezier.get(0));


    }

    public void bezier(float[][] floats, int pilihan) {
        int indexBezier = 0;
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

                if (pilihan == 0) {
                    titikBezier.get(0).addVertices(new Vector3f(x, y, z));
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

    public void rotateObject(float degree, float x, float y, float z) {
        objectsBangunan.get(0).rotateObject((float)Math.toRadians(degree), x, y ,z);
    }


    public void scaleObject(float scaleX, float scaleY, float scaleZ) {
        for (Sphere sphere : objectsBangunan) {
            sphere.scaleObject(scaleX, scaleY, scaleZ);
        }

    }

    public void translateObject(float x, float y, float z) {
        objectsBangunan.get(0).translateObject(x,y,z);
    }

    public void loop(){
        for (Sphere sphere: objectsBangunan){
            sphere.draw(camera, projection);
        }

    }
}
