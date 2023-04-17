#version 330
// out ngelempar variable yang ada di sini keluar
out vec4 frag_color;
// kalo in itu berharap masuk dari vert
in vec4 out_color;
void main(){
//    frag_color = vec4(1.0, 0.0, 0.0, 1.0);
    frag_color = out_color;
}