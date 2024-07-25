precision mediump float;
uniform highp vec4 BrushColor;
uniform highp vec4 PenThickness;
uniform sampler2D PenTexture;
uniform sampler2D BrushTexture;
varying highp vec4 xlv_COLOR0;
varying highp vec3 xlv_TEXCOORD0;
varying highp vec2 xlv_TEXCOORD1;
void main ()
{
  highp vec4 finalColor_1;
  highp vec2 tmpvar_2;
  tmpvar_2.x = 0.5;
  tmpvar_2.y = xlv_TEXCOORD0.y;
  lowp vec4 tmpvar_3;
  tmpvar_3 = texture2D (PenTexture, tmpvar_2);
  highp vec4 fadedColor_4;
  fadedColor_4.xyz = xlv_COLOR0.xyz;
  fadedColor_4.w = 0.0;
  lowp vec4 tmpvar_5;
  tmpvar_5 = texture2D (BrushTexture, xlv_TEXCOORD1);
  finalColor_1 = ((tmpvar_3 * mix (fadedColor_4, xlv_COLOR0, vec4(
    min ((min (xlv_TEXCOORD0.x, (1.0 - xlv_TEXCOORD0.x)) / (PenThickness.w / (
      (PenThickness.w * 2.0)
     + 
      (PenThickness.x - PenThickness.w)
    ))), 1.0)
  ))) * (BrushColor * tmpvar_5));
  gl_FragData[0] = finalColor_1;
}

