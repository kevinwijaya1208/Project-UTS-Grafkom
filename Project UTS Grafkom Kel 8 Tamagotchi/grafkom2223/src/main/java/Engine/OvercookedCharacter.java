//package Engine;
//
//import org.lwjgl.BufferUtils;
//import org.lwjgl.glfw.GLFW;
//import org.lwjgl.glfw.GLFWErrorCallback;
//import org.lwjgl.glfw.GLFWKeyCallback;
//import org.lwjgl.opengl.GL;
//import org.lwjgl.opengl.GL30;
//import org.lwjgl.system.MemoryUtil;
//import org.lwjgl.util.glu.GLU;
//
//import java.nio.FloatBuffer;
//
//public class OvercookedCharacter {
//
//    private static final int WIDTH = 800;
//    private static final int HEIGHT = 600;
//
//    private static long window;
//
//    private int vaoId;
//    private int vertexCount;
//
//    private float x = 0.0f;
//    private float y = 0.0f;
//    private float z = -5.0f;
//    private float rx = 0.0f;
//    private float ry = 0.0f;
//    private float rz = 0.0f;
//
//    public void init() throws Exception {
//        GLFWErrorCallback.createPrint(System.err).set();
//        if (!GLFW.glfwInit()) {
//            throw new IllegalStateException("Unable to initialize GLFW");
//        }
//
//        GLFW.glfwDefaultWindowHints();
//        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
//        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);
//
//        window = GLFW.glfwCreateWindow(WIDTH, HEIGHT, "Overcooked Character", MemoryUtil.NULL, MemoryUtil.NULL);
//        if (window == MemoryUtil.NULL) {
//            throw new RuntimeException("Failed to create the GLFW window");
//        }
//
//        GLFW.glfwSetKeyCallback(window, new GLFWKeyCallback() {
//            @Override
//            public void invoke(long window, int key, int scancode, int action, int mods) {
//                if (key == GLFW.GLFW_KEY_ESCAPE && action == GLFW.GLFW_RELEASE) {
//                    GLFW.glfwSetWindowShouldClose(window, true);
//                }
//            }
//        });
//
//        GLFW.glfwMakeContextCurrent(window);
//        GLFW.glfwSwapInterval(1);
//        GLFW.glfwShowWindow(window);
//
//        GL.createCapabilities();
//
//        // create the character model
//        createModel();
//    }
//
//    private void createModel() {
//        // define the vertices of the character model
//        float[] vertices = {
//                // body
//                -1.0f, 1.0f, 0.0f,
//                1.0f, 1.0f, 0.0f,
//                1.0f, -1.0f, 0.0f,
//                -1.0f, -1.0f, 0.0f,
//                // left leg
//                -1.0f, -1.0f, 0.0f,
//                -1.0f, -2.0f, 0.0f,
//                -0.5f, -2.0f, 0.0f,
//                -0.5f, -1.0f, 0.0f,
//                // right leg
//                0.5f, -1.0f, 0.0f,
//                0.5f, -2.0f, 0.0f,
//                1.0f, -2.0f, 0.0f,
//                1.0f, -1.0f, 0.0f,
//                // left arm
//                -1.0f, 1.0f, 0.0f,
//                -1.5f, 1.0f, 0.0f,
//                -1.5f, 0.5f, 0.0f,
//                -1.0f, 0.5f, 0.0f,
//                // right arm
//                1.0f, 1.0f, 0.0f,
//                1.5f, 1.0f, 0.0f,
//                1.5f, 0.5f, 0.0f,
//                1.0f, 0.5f, 0.0f,
//                // hat
//                -1.5f, 1.0f, 0.5f,
//                1.5f, 1.0f, 0.5f,
//                0.0f, 2.0f, 0.5f
//        };
//
//        vertexCount = vertices.length / 3;
//
//        // create a FloatBuffer to store the vertices
//        FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(vertices.length);
//        verticesBuffer.put(vertices);
//        verticesBuffer.flip();
//
//        // create the vertex array object (VAO)
//        vaoId = GL30.glGenVertexArrays();
//        GL30.glBindVertexArray(vaoId);
//
//        // create the vertex buffer object (VBO)
//        int vboId = GL30.glGenBuffers();
//        GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, vboId);
//        GL30.glBufferData(GL30.GL_ARRAY_BUFFER, verticesBuffer, GL30.GL_STATIC_DRAW);
//        GL30.glVertexAttribPointer(0, 3, GL30.GL_FLOAT, false, 0, 0);
//        GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, 0);
//
//        GL30.glBindVertexArray(0);
//    }
//
//    public void loop() {
//        while (!GLFW.glfwWindowShouldClose(window)) {
//            update();
//            render();
//
//            GLFW.glfwSwapBuffers(window);
//            GLFW.glfwPollEvents();
//        }
//    }
//
//    private void update() {
//        // rotate the character model
//        rx += 1.0f;
//        ry += 1.0f;
//        rz += 1.0f;
//    }
//
//    private void render() {
//        GL30.glClear(GL30.GL_COLOR_BUFFER_BIT | GL30.GL_DEPTH_BUFFER_BIT);
//        GL30.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
//
//        GL30.glMatrixMode(GL30.GL_PROJECTION);
//        GL30.glLoadIdentity();
//        GL30.glPerspective((float) Math.toDegrees(fov), (float) WIDTH / (float) HEIGHT, 0.1f, 100.0f);
//
//        GL30.glMatrixMode(GL30.GL_MODELVIEW);
//        GL30.glLoadIdentity();
//        GL30.glTranslatef(x, y, z);
//        GL30.glRotatef(rx, 1.0f, 0.0f, 0.0f);
//        GL30.glRotatef(ry, 0.0f, 1.0f, 0.0f);
//        GL30.glRotatef(rz, 0.0f, 0.0f, 1.0f);
//
//        GL30.glBindVertexArray(vaoId);
//        GL30.glDrawArrays(GL30.GL_QUADS, 0, vertexCount);
//        GL30.glBindVertexArray(0);
//    }
//
//    public void destroy() {
//        GL30.glDeleteVertexArrays(vaoId);
//        GLFW.glfwTerminate();
//    }
//
//    public static void main(String[] args) {
//        OvercookedCharacter overcooked
//                = new OvercookedCharacter();
//        overcooked.loop();
//        overcooked.destroy();
//    }
//}
//
//
//
