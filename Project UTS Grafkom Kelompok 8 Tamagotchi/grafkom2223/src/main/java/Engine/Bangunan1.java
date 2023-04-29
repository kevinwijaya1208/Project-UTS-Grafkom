package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;

// Kevin Wijaya - c14210124
public class Bangunan1 {
    Camera camera;
    Projection projection;
    public boolean curve;
    public ArrayList<Object> titikBezier = new ArrayList<>();
    public ArrayList<Sphere> objectsBangunan = new ArrayList<>();

    public Bangunan1(Camera camera, Projection projection){
        this.camera = camera;
        this.projection = projection;
    }

    public void init() {
        // box putih tengah
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
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.8f, 0.5f, 0.5f, 3
        ));

        // tabung di atas kiri
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
        ), new Vector4f(0.458f, 0.69f, 0.85f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.03f, 0.2f, 11
        ));
        objectsBangunan.get(1).rotateObject((float) Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        objectsBangunan.get(1).translateObject(-0.2f, 0.455f, 0.0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(1));

        // tabung di atas kanan
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
        ), new Vector4f(0.458f, 0.69f, 0.85f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.03f, 0.2f, 11
        ));
        objectsBangunan.get(2).rotateObject((float) Math.toRadians(90), 1.0f, 0.0f, 0.0f);
        objectsBangunan.get(2).translateObject(0.2f, 0.455f, 0.0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(2));

        // tabung di atas tengah
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
        ), new Vector4f(0.458f, 0.69f, 0.85f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.03f, 0.46f, 11
        ));
        objectsBangunan.get(3).rotateObject((float) Math.toRadians(90), 0.0f, 1.0f, 0.0f);
        objectsBangunan.get(3).translateObject(-0.23f, 0.455f, 0.0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(3));

        // prisma segienam putih di atas
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
        ), new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.21f, 0.1f, 0.03f, 15
        ));
        objectsBangunan.get(4).translateObject(0.0f, 0.53f, 0.0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(4));

        // tanda kotak hospital yg horizontal yang di depan
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
        ), new Vector4f(1.0f, 0.8f, 0.89f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.1f, 0.03f, 0.01f, 3
        ));
        objectsBangunan.get(5).translateObject(0.0f, 0.53f, 0.02f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(5));

        // tanda kotak hospital yg horizontal yang di belakang
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
        ), new Vector4f(1.0f, 0.8f, 0.89f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.1f, 0.03f, 0.01f, 3
        ));
        objectsBangunan.get(6).translateObject(0.0f, 0.53f, -0.02f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(6));

        // tanda kotak hospital yg vertikal yang di depan
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
        ), new Vector4f(1.0f, 0.8f, 0.89f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.1f, 0.01f, 3
        ));
        objectsBangunan.get(7).translateObject(0.0f, 0.53f, 0.02f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(7));

        // tanda kotak hospital yg vertikal yang di belakang
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
        ), new Vector4f(1.0f, 0.8f, 0.89f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.1f, 0.01f, 3
        ));
        objectsBangunan.get(8).translateObject(0.0f, 0.53f, -0.02f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(8));

        // mata di depan kiri
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.1f, 0.01f, 1
        ));
        objectsBangunan.get(9).scaleObject(0.07f, 0.07f, 0.02f);
        objectsBangunan.get(9).translateObject(-0.1f, 0.17f, 0.26f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(9));

        // mata di depan kanan
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.1f, 0.01f, 1
        ));
        objectsBangunan.get(10).scaleObject(0.07f, 0.07f, 0.02f);
        objectsBangunan.get(10).translateObject(0.1f, 0.17f, 0.26f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(10));

        // pembatas hitam muka
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.8f, 0.03f, 0.1f, 3
        ));
        objectsBangunan.get(11).scaleObject(1.0f, 1.0f, 0.1f);
        objectsBangunan.get(11).translateObject(0.0f, -0.025f, 0.26f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(11));

        // pipi kiri di depan
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
        ), new Vector4f(1.0f, 0.6f, 0.8f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.1f, 0.01f, 1
        ));
        objectsBangunan.get(12).scaleObject(0.14f, 0.14f, 0.02f);
        objectsBangunan.get(12).translateObject(-0.25f, -0.025f, 0.261f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(12));

        // pipi kiri di depan
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
        ), new Vector4f(1.0f, 0.6f, 0.8f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.1f, 0.01f, 1
        ));
        objectsBangunan.get(13).scaleObject(0.14f, 0.14f, 0.02f);
        objectsBangunan.get(13).translateObject(0.25f, -0.025f, 0.261f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(13));

        // pipi kiri di depan
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
        ), new Vector4f(0.6f, 1.0f, 1.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.1f, 0.01f, 1
        ));
        objectsBangunan.get(14).scaleObject(0.1f, 0.1f, 0.02f);
        objectsBangunan.get(14).translateObject(-0.25f, -0.025f, 0.265f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(14));

        // pipi kanan di depan
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
        ), new Vector4f(0.6f, 1.0f, 1.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.1f, 0.01f, 1
        ));
        objectsBangunan.get(15).scaleObject(0.1f, 0.1f, 0.02f);
        objectsBangunan.get(15).translateObject(0.25f, -0.025f, 0.265f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(15));

        // bulu mata kiri atas 1
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.1f, 0.01f, 7
        ));
        objectsBangunan.get(16).scaleObject(0.03f, 0.04f, 0.02f);
        objectsBangunan.get(16).translateObject(-0.09f, 0.24f, 0.26f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(16));

        // bulu mata kiri atas 2
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.1f, 0.01f, 7
        ));
        objectsBangunan.get(17).rotateObject((float) Math.toRadians(25), 0.0f, 0.0f, 1.0f);
        objectsBangunan.get(17).scaleObject(0.03f, 0.04f, 0.02f);
        objectsBangunan.get(17).translateObject(-0.135f, 0.23f, 0.26f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(17));

        // bulu mata kanan atas 1
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.1f, 0.01f, 7
        ));
        objectsBangunan.get(18).scaleObject(0.03f, 0.04f, 0.02f);
        objectsBangunan.get(18).translateObject(0.11f, 0.24f, 0.26f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(18));

        // bulu mata kanan atas 2
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.1f, 0.01f, 7
        ));
        objectsBangunan.get(19).rotateObject((float) Math.toRadians(25), 0.0f, 0.0f, 1.0f);
        objectsBangunan.get(19).scaleObject(0.03f, 0.04f, 0.02f);
        objectsBangunan.get(19).translateObject(0.07f, 0.23f, 0.26f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(19));

        // bibir atas
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
        ), new Vector4f(1.0f, 0.215f, 0.6f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.1f, 0.01f, 2
        ));
//        objectsBangunan.get(20).rotateObject((float)Math.toRadians(25),0.0f,0.0f,1.0f);
        objectsBangunan.get(20).scaleObject(0.1f, 0.1f, 0.02f);
        objectsBangunan.get(20).translateObject(0.0f, -0.021f, 0.26f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(20));

        // bibir bawah
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
        ), new Vector4f(1.0f, 0.215f, 0.6f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.03f, 0.1f, 0.01f, 2
        ));
        objectsBangunan.get(21).rotateObject((float) Math.toRadians(190), 0.0f, 0.0f, 1.0f);
        objectsBangunan.get(21).scaleObject(0.1f, 0.1f, 0.02f);
        objectsBangunan.get(21).translateObject(0.0f, -0.025f, 0.26f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(21));

        // pintu
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.3f, 0.15f, 0.01f, 3
        ));
        objectsBangunan.get(22).translateObject(0.0f, -0.175f, 0.26f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(22));

        // pintu tengah biru
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
        ), new Vector4f(0.6f, 1.0f, 1.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.1f, 0.09f, 0.01f, 3
        ));
        objectsBangunan.get(23).translateObject(0.0f, -0.196f, 0.27f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(23));

        // pintu kiri biru
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
        ), new Vector4f(0.6f, 1.0f, 1.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.085f, 0.09f, 0.01f, 3
        ));
        objectsBangunan.get(24).translateObject(-0.1f, -0.196f, 0.27f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(24));

        // pintu kanan biru
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
        ), new Vector4f(0.6f, 1.0f, 1.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.085f, 0.09f, 0.01f, 3
        ));
        objectsBangunan.get(25).translateObject(0.1f, -0.196f, 0.27f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(25));

        // pintu atas tengah biru
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
        ), new Vector4f(0.6f, 1.0f, 1.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.1f, 0.04f, 0.01f, 3
        ));
        objectsBangunan.get(26).translateObject(0.0f, -0.125f, 0.27f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(26));

        // pintu atas kiri biru
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
        ), new Vector4f(0.6f, 1.0f, 1.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.085f, 0.04f, 0.01f, 3
        ));
        objectsBangunan.get(27).translateObject(-0.1f, -0.125f, 0.27f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(27));

        // pintu atas kanan biru
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
        ), new Vector4f(0.6f, 1.0f, 1.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.085f, 0.04f, 0.01f, 3
        ));
        objectsBangunan.get(28).translateObject(0.1f, -0.125f, 0.27f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(28));

        // handsaplast
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
        ), new Vector4f(0.752f, 0.411f, 0.113f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.2f, 0.06f, 0.01f, 3
        ));
        objectsBangunan.get(29).rotateObject((float)Math.toRadians(35),0.0f,0.0f,1.0f);
        objectsBangunan.get(29).translateObject(0.29f, -0.165f, 0.27f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(29));

        // handsaplast dalam
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
        ), new Vector4f(0.6f, 1.0f, 1.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.1f, 0.045f, 0.01f, 3
        ));
        objectsBangunan.get(30).rotateObject((float)Math.toRadians(35),0.0f,0.0f,1.0f);
        objectsBangunan.get(30).translateObject(0.29f, -0.165f, 0.275f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(30));


        // pembatas hitam belakang
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.8f, 0.03f, 0.1f, 3
        ));
        objectsBangunan.get(31).scaleObject(1.0f, 1.0f, 0.1f);
        objectsBangunan.get(31).translateObject(0.0f, -0.025f, -0.257f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(31));

        // pembatas hitam samping kiri
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.5f, 0.03f, 0.1f, 3
        ));
        objectsBangunan.get(32).scaleObject(1.0f, 1.0f, 0.1f);
        objectsBangunan.get(32).rotateObject((float)Math.toRadians(90), 0.0f,1.0f,0.0f);
        objectsBangunan.get(32).translateObject(-0.4f, -0.025f, 0.0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(32));

        // pembatas hitam samping kanan
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 0.5f, 0.03f, 0.1f, 3
        ));
        objectsBangunan.get(33).scaleObject(1.0f, 1.0f, 0.1f);
        objectsBangunan.get(33).rotateObject((float)Math.toRadians(90), 0.0f,1.0f,0.0f);
        objectsBangunan.get(33).translateObject(0.4f, -0.025f, 0.0f);
        objectsBangunan.get(0).getChildObject().add(objectsBangunan.get(33));

        // latar bawahnya
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
        ), new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), // ini untuk warna object
                0.0f, 0.0f, 0.0f, 30.0f, 0.01f, 30.0f, 3
        ));
        objectsBangunan.get(34).translateObject(0.0f,-0.26f,0.0f);
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
