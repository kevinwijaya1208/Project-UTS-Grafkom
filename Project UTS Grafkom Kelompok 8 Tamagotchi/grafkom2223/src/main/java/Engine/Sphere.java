package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.BufferUtils;

import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class Sphere extends Elips{
    public float radiusz;
    public float centerz;

    List<Integer> index;

    int ibo;
    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerx, float centery, float centerz, float radiusx, float radiusy, float radiusz, int pilihan) {
        super(shaderModuleDataList, vertices, color, centerx, centery, radiusx, radiusy);
        this.centerz = centerz;
        this.radiusz = radiusz;
        if (pilihan == 0){
            createElipsoid();
        } else if (pilihan == 1) {
            createSphere();
        } else if (pilihan == 2){
            createSphereSetengah();
        } else if (pilihan == 3){
            createBox();
        } else if (pilihan == 4){
            createHyperboloid1();
        } else if (pilihan == 5){
            createHyperboloid2();
        } else if (pilihan == 6){
            createEllipticCone();
        } else if (pilihan == 7){
            createEllipticParaboloid();
        } else if (pilihan == 8){
            createHyperParaboloid();
        } else if (pilihan == 9){
            createEllipticConeSetengah();
        } else if (pilihan == 10) {
//            createTorus(0.4f, 0.2f, 32, 16);
        } else if (pilihan == 11){
            createCylinder();
        } else if (pilihan == 12){
            createElipsoidCustom(radiusx,radiusy,radiusz);
        } else if (pilihan == 13){
            createPrismaSegitiga();
        } else if (pilihan == 14){
            createEllipticParaboloidBolong();
        } else if (pilihan == 15){
            createPrismaSegienam();
        }
        setupVAOVBO();
    }

//    @Override
//    public void draw()
//    {
//        drawSetup(camera,projection);
//        glLineWidth(1);
//        glPointSize(5);
//        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
//    }

//    public void draw(){
//        drawSetup();
//        // Bind IBO dan draw
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
//        glDrawElements(GL_TRIANGLE_STRIP, index.size(), GL_UNSIGNED_INT, 0);
//        // kalo mau lingkaran tanpa fill ganti ke GL_LINES
//    }


    public void createPrismaSegienam(){
        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        // Titik 1 kiri atas belakang
        temp.x = centerx - radiusx/2;
        temp.y = centery + radiusy/2;
        temp.z = centerz - radiusz/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 2 kiri tengah belakang
        temp.x = centerx - radiusx / 1.2f;
        temp.y = centery;
        temp.z = centerz - radiusz/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 3 kiri bawah belakang
        temp.x = centerx - radiusx/2;
        temp.y = centery - radiusy/2;
        temp.z = centerz - radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 4 kanan bawah belakang
        temp.x = centerx + radiusx/2;
        temp.y = centery - radiusy/2;
        temp.z = centerz - radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 5 kanan tengah belakang
        temp.x = centerx + radiusx / 1.2f;
        temp.y = centery;
        temp.z = centerz - radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 6 kanan atas belakang
        temp.x = centerx + radiusx/2;
        temp.y = centery + radiusy/2;
        temp.z = centerz - radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();


        // Titik 7 kiri atas depan
        temp.x = centerx - radiusx/2;
        temp.y = centery + radiusy/2;
        temp.z = centerz + radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 8 kiri tengah depan
        temp.x = centerx - radiusx / 1.2f;
        temp.y = centery;
        temp.z = centerz + radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 9 kiri bawah depan
        temp.x = centerx - radiusx / 2;
        temp.y = centery - radiusy / 2;
        temp.z = centerz + radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 10 kanan bawah depan
        temp.x = centerx + radiusx / 2;
        temp.y = centery - radiusy / 2;
        temp.z = centerz + radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 11 kanan tengah depan
        temp.x = centerx + radiusx / 1.2f;
        temp.y = centery;
        temp.z = centerz + radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 12 kanan atas depan
        temp.x = centerx + radiusx/2;
        temp.y = centery + radiusy/2;
        temp.z = centerz + radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));

        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(0));

        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));

        // kotak depan
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(8));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(8));
        vertices.add(tempVertices.get(9));

        vertices.add(tempVertices.get(9));
        vertices.add(tempVertices.get(11));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(9));
        vertices.add(tempVertices.get(10));
        vertices.add(tempVertices.get(11));


        // kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(11));

        vertices.add(tempVertices.get(11));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));

        // kotak atas
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(8));
        vertices.add(tempVertices.get(9));

        vertices.add(tempVertices.get(9));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));

        // kotak samping kiri atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(0));

        // kotak samping kiri bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(8));

        vertices.add(tempVertices.get(8));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(1));

        // kotak samping kanan atas
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(11));
        vertices.add(tempVertices.get(10));

        vertices.add(tempVertices.get(10));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));

        // kotak samping kanan bawah
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(10));
        vertices.add(tempVertices.get(9));

        vertices.add(tempVertices.get(9));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(4));
    }
    public void createPrismaSegitiga(){
        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        // Titik 1 tengah atas belakang
        temp.x = centerx;
        temp.y = centery + radiusy/2;
        temp.z = centerz - radiusz/2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 2 kiri bawah belakang
        temp.x = centerx - radiusx/2;
        temp.y = centery - radiusy/2;
        temp.z = centerz - radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 3 kanan bawah belakang
        temp.x = centerx + radiusx/2;
        temp.y = centery - radiusy/2;
        temp.z = centerz - radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 4 tengah atas depan
        temp.x = centerx;
        temp.y = centery + radiusy/2;
        temp.z = centerz + radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 5 kiri bawah depan
        temp.x = centerx - radiusx / 2;
        temp.y = centery - radiusy / 2;
        temp.z = centerz + radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 6 kanan bawah depan
        temp.x = centerx + radiusx/2;
        temp.y = centery - radiusy/2;
        temp.z = centerz + radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        // kotak depan
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));

        // kotak samping kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(4));

        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));

        // kotak samping kanan
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(5));

        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));

        // kotak bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(5));

        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(1));
    }
    public void createCylinder(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double i = 0;i<360;i+=0.1f){
            float x = (float) (centerx + radiusx *  Math.cos(Math.toRadians(i)));
            float y = (float) (centery + radiusy * Math.sin(Math.toRadians(i)));
            temp.add(new Vector3f(x,y,0.0f));
            temp.add(new Vector3f(x,y,radiusz));
        }

        vertices = temp;

    }

    public void createTorus(float r1, float r2, int numSegments, int numSides) {
        vertices.clear();
        ArrayList<Integer> index = new ArrayList<>();

        float phi = 0, theta = 0;
        float dphi = (float) (2.0 * Math.PI / numSides);
        float dtheta = (float) (2.0 * Math.PI / numSegments);

        for (int i = 0; i < numSides; i++) {
            phi = i * dphi;
            for (int j = 0; j < numSegments; j++) {
                theta = j * dtheta;

                Vector3f v = new Vector3f();
                v.x = (float) ((r1 + r2 * Math.cos(theta)) * Math.cos(phi));
                v.y = (float) ((r1 + r2 * Math.cos(theta)) * Math.sin(phi));
                v.z = (float) (r2 * Math.sin(theta));
                vertices.add(v);
            }
        }

        for (int i = 0; i < numSides; i++) {
            for (int j = 0; j < numSegments; j++) {
                int i1 = i * numSegments + j;
                int i2 = ((i + 1) % numSides) * numSegments + j;
                int i3 = i * numSegments + ((j + 1) % numSegments);
                int i4 = ((i + 1) % numSides) * numSegments + ((j + 1) % numSegments);
                index.add(i1);
                index.add(i3);
                index.add(i2);
                index.add(i2);
                index.add(i3);
                index.add(i4);
            }
        }
        this.index = index;
        setupIBO();
    }

    public void setupIBO() {
        // Create the index buffer object
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);

        // Get the indices as an int array
        int[] indices = new int[index.size()];
        for (int i = 0; i < index.size(); i++) {
            indices[i] = index.get(i);
        }

        // Send the indices to the IBO
        IntBuffer indicesBuffer = BufferUtils.createIntBuffer(indices.length);
        indicesBuffer.put(indices);
        indicesBuffer.flip();
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW);
    }

    public void createBox(){
        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        // Tititk 1 kiri atas belakang
        temp.x = centerx - radiusx/2;
        temp.y = centery + radiusy/2;
        temp.z = centerz - radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 2 kiri bawah belakang
        temp.x = centerx - radiusx/2;
        temp.y = centery - radiusy/2;
        temp.z = centerz - radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 3 kanan bawah belakang
        temp.x = centerx + radiusx/2;
        temp.y = centery - radiusy/2;
        temp.z = centerz - radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // Titik 4 kanan atas belakang
        temp.x = centerx + radiusx/2;
        temp.y = centery + radiusy/2;
        temp.z = centerz - radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 5 kiri atas depan
        temp.x = centerx - radiusx/2;
        temp.y = centery + radiusy/2;
        temp.z = centerz + radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 6 kiri bawah depan
        temp.x = centerx - radiusx / 2;
        temp.y = centery - radiusy / 2;
        temp.z = centerz + radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 7 kanan bawah depan
        temp.x = centerx + radiusx/2;
        temp.y = centery - radiusy/2;
        temp.z = centerz + radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // titik 8 kanan atas depan
        temp.x = centerx + radiusx/2;
        temp.y = centery + radiusy/2;
        temp.z = centerz + radiusz / 2;
        tempVertices.add(temp);
        temp = new Vector3f();

        // kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));

        // kotak depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));

        // kotak samping kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(4));

        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));

        // kotak samping kanan
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));

        // kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));

        // kotak bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(1));
    }

    public void createSphere(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 144, sectorCount = 144;
        float x,y,z,xy,nx,ny,nz;
        float sectorStep = (float)(2 * Math.PI )/ sectorCount; //sector count
        float stackStep = (float)Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        for(int i=0;i<=stackCount;i++){
            stackAngle = (float)Math.PI/2 - i * stackStep;
            xy = (float) (0.5f * Math.cos(stackAngle));
            z = (float) (0.5f * Math.sin(stackAngle));
            for(int j=0;j<sectorCount;j++){
                sectorAngle = j * sectorStep;
                x = (float) (xy * Math.cos(sectorAngle));
                y = (float) (xy * Math.sin(sectorAngle));
                temp.add(new Vector3f(x,y,z));
            }
        }

        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(18-1)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }
        }
        this.index = temp_indices;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);

    }

    public void createSphereSetengah(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 72, sectorCount = 72;
        float x,y,z,xy;
        float sectorStep = (float)(2 * Math.PI )/ sectorCount / 1.945f; //sector count
        float stackStep = (float)Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        for(int i=0;i<=stackCount;i++){
            stackAngle = (float)Math.PI/2 - i * stackStep;
            xy = (float) (0.5f * Math.cos(stackAngle));
            z = (float) (0.5f * Math.sin(stackAngle));
            for(int j=0;j<sectorCount;j++){
                sectorAngle = j * sectorStep;
                x = (float) (xy * Math.cos(sectorAngle));
                y = (float) (xy * Math.sin(sectorAngle));
                temp.add(new Vector3f(x,y,z));
            }
        }

        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(18-1)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }
        }
        this.index = temp_indices;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);

    }

//    public void drawIndices(){
//        drawSetup();
//        // Bind IBO dan draw
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
//        glDrawElements(GL_TRIANGLES, index.size(), GL_UNSIGNED_INT, 0);
//        // kalo mau lingkaran tanpa fill ganti ke GL_LINES
//    }

    public void createElipsoid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.3f * (float)(Math.cos(v) * Math.cos(u));
                float y = 0.2f * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.2f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public void createElipsoidCustom(float radx, float rady, float radz){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = rady * (float)(Math.cos(v) * Math.cos(u));
                float y = radx * (float)(Math.cos(v) * Math.sin(u));
                float z = 0.5f * (float)(Math.sin(v));
                temp.add(new Vector3f(x,y,z));
            }
        }

        vertices = temp;

    }

    public void createHyperboloid1(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
                float x = 0.1f * (float)(1/Math.cos(v) * Math.cos(u));
                float y = 0.1f * (float)(1/Math.cos(v) * Math.sin(u));
                float z = 0.1f * (float)(Math.tan(v));
                temp.add(new Vector3f(x,y,z));
            }
        }

        vertices = temp;

    }

    public void createHyperboloid2(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
                float x = 0.1f * (float)(Math.tan(v) * Math.cos(u));
                float y = 0.1f * (float)(Math.tan(v) * Math.sin(u));
                float z = 0.1f * (float)(1/Math.cos(v));
                temp.add(new Vector3f(x,y,z));
            }
            for (double u = Math.PI / 2; u <= 3 * Math.PI / 2; u += Math.PI / 60) {
                float x = -0.1f * (float) (Math.tan(v) * Math.cos(u));
                float y = -0.1f * (float) (Math.tan(v) * Math.sin(u));
                float z = -0.1f * (float) (1 / Math.cos(v));
                temp.add(new Vector3f(x, y, z));
            }
            // yg ini tadi disuru -1 trs jadi atas bawah
        }

        vertices = temp;
    }

    public void createEllipticCone(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.1f * (float)((v) * Math.cos(u));
                float y = 0.1f * (float)((v) * Math.sin(u));
                float z = 0.1f * (float)((v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public void createEllipticConeSetengah(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= 0; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.15f * (float)((v) * Math.cos(u));
                float y = 0.15f * (float)((v) * Math.sin(u));
                float z = 0.15f * (float)((v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public void createEllipticParaboloid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= Math.PI; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.1f * (float)((v) * Math.cos(u));
                float z = 0.1f * (float)((v) * Math.sin(u));
                float y = -0.1f * (float)(Math.pow(v,2));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public void createEllipticParaboloidBolong(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 1; v<= Math.PI; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.1f * (float)((v) * Math.cos(u));
                float z = 0.1f * (float)((v) * Math.sin(u));
                float y = -0.1f * (float)(Math.pow(v,2));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public void createHyperParaboloid(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = Math.PI/2; v<= Math.PI; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = 0.1f * (float)((v) * Math.tan(u));
                float y = 0.1f * (float)((v) * 1/Math.cos(u));
                float z = 0.1f * (float)(Math.pow(v,2));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;
    }

    public float getCenterX() {
        return centerx;
    }

    public float getCenterY() {
        return centery;
    }

    public float getCenterZ() {
        return centerz;
    }
}
