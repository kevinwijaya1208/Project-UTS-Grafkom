package Engine;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL30.*;

public class Object extends ShaderProgram{
    List<Vector3f> vertices;
    int vao;
    int vbo;

    Vector4f color;

    UniformsMap uniformsMap;

    List<Vector3f> verticesColor;

    int vboColor;
    public Matrix4f model;

    public List<Object> getChildObject() {
        return childObject;
    }

    public void setChildObject(List<Object> childObject) {
        this.childObject = childObject;
    }

    List<Object>childObject;

    public Vector3f updateCenterPoint(){
        Vector3f centerTemp = new Vector3f();
        model.transformPosition(0.0f,0.0f,0.0f, centerTemp);
        return centerTemp;
    }

    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        // selalu kasih setupvaovbo supaya shader tahu datanya berubah, verticesnya berubah tempat
        setupVAOVBO();
        this.color = color;
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");
        uniformsMap.createUniform("model");
        // defaultnya matrix identitas
        model = new Matrix4f();
        childObject = new ArrayList<>();
    }


    public Object(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);
        this.vertices = vertices;
//        this.curve = vertices;
        this.verticesColor = verticesColor;
        // selalu kasih setupvaovbo supaya shader tahu datanya berubah, verticesnya berubah tempat
        setupVAOVBOWithVerticesColor();
    }

    public void setupVAOVBO(){
        // set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        // mengirim vertices ke shader
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);

    }

//    public void setupVAOVBOBerzier(){
//        // set vao
//        vao = glGenVertexArrays();
//        glBindVertexArray(vao);
//
//        vbo = glGenBuffers();
//        glBindBuffer(GL_ARRAY_BUFFER, vbo);
//        // mengirim vertices ke shader
//        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesCurve), GL_STATIC_DRAW);
//    }

    public void setupVAOVBOWithVerticesColor(){
        // set vao
        vao = glGenVertexArrays();
        glBindVertexArray(vao);
        // set vbo
        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        // mengirim vertices ke shader
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
        // set vboColor
        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        // mengirim vertices ke shader
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
    }

    public void drawSetup(){
        bind();
        uniformsMap.setUniform("uni_color", color);
        uniformsMap.setUniform("model", model);
        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
        // urutannya dari sini, ke vert, ke frag, baru ke layar
    }

    public void drawSetupWithVerticesColor(){
        bind();
        // Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0, 0);
        // urutannya dari sini, ke vert, ke frag, baru ke layar
        // Bind VBOColor
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1, 3, GL_FLOAT, false, 0, 0);
        // urutannya dari sini, ke vert, ke frag, baru ke layar
    }

    public void draw(){
        drawSetup();
        // draw the vertices
        glLineWidth(1); // ketebalan garis
        glPointSize(0); // besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT

        glDrawArrays(GL_TRIANGLES,0, vertices.size());
        for (Object child:childObject){
            child.draw();
        }
        // kalo mau draw kotak langsung dengan 4 titik bisa pake GL_POLYGON, nentuin koordinatnya ntar di mainnya
//        glDrawArrays(GL_LINE_LOOP,0, vertices.size());
    }

    public void drawWithVerticesColor(){
        drawSetupWithVerticesColor();
        // draw the vertices
        glLineWidth(10); // ketebalan garis
        glPointSize(10); // besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        // kalo triangle bikin segitiganya dua kali, kalo triangle fan kalo ditumpuk dia cari tahu ada garis yg berhimpit ga untuk dipinjam
        //GL_POINT

//        glDrawArrays(GL_TRIANGLES,0, vertices.size());
//        glDrawArrays(GL_LINE_LOOP,0, vertices.size());
        glDrawArrays(GL_POLYGON,0, vertices.size());
    }

    public void drawLine(){
        drawSetup();
        // draw the vertices
        glLineWidth(5); // ketebalan garis
        glPointSize(5); // besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT

        glDrawArrays(GL_LINE_STRIP,0, vertices.size());
//        glDrawArrays(GL_LINE_LOOP,0, vertices.size());
    }

    public void drawLineBerzier(){
        drawSetup();
        // draw the vertices
        glLineWidth(5); // ketebalan garis
        glPointSize(1); // besar kecil vertex
        //wajib
        //GL_LINES
        //GL_LINE_STRIP
        //GL_LINE_LOOP
        //GL_TRIANGLES
        //GL_TRIANGLE_FAN
        //GL_POINT

        glDrawArrays(GL_LINE_STRIP,0, vertices.size());
//        glDrawArrays(GL_LINE_LOOP,0, vertices.size());
    }

    public void addVertices(Vector3f newVector){
        vertices.add(newVector);
        setupVAOVBO();
    }

    public void addVertices(int i, Vector3f newVector){
        vertices.add(i, newVector);
        setupVAOVBO();
    }

    public void clearVertices(int i){
        vertices.remove(i);
        setupVAOVBO();
    }

    public void changeVertices(int i, Vector3f newVector){
        vertices.set(i, newVector);
        setupVAOVBO();
    }

    public void move(float centerx, float centery){
    }

    public boolean checkOverlap(float x1, float y1){
        return false;
//        float jarak = (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
//        System.out.println("Jarak Dua Titik: " + jarak);
//        if (jarak > 0.2f) {
//            return false;
//        } else {
//            return true;
//        }
    }

    public boolean checkKotak(float x1, float y1){
        return false;
//        float jarak = (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
//        System.out.println("Jarak Dua Titik: " + jarak);
//        if (jarak < 0.1f) {
//            return true;
//        } else {
//            return false;
//        }
    }

    public float getCenterx(){
        return 0;
    }

    public float getCentery(){
        return 0;
    }

    public void drawIndices(){}

    public float translateObject(Float offsetX, Float offsetY, Float offsetZ){
        model = new Matrix4f().translate(offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for (Object child:childObject){
            child.translateObject(offsetX, offsetY, offsetZ);
        }
        return model.m30();
    }

    public float rotateObject(Float degree, Float offsetX, Float offsetY, Float offsetZ){
        model = new Matrix4f().rotate(degree, offsetX, offsetY, offsetZ).mul(new Matrix4f(model));
        for (Object child:childObject){
            child.rotateObject(degree, offsetX, offsetY, offsetZ);
        }
        return model.m30();
    }

    public void scaleObject(Float x, Float y, Float z){
        model = new Matrix4f().scale(x,y,z).mul(new Matrix4f(model));
    }

    public Matrix4f getModel(){
        return this.model;
    }
}
