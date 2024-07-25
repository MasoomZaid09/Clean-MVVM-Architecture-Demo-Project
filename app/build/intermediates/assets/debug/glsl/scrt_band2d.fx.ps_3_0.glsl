precision mediump float;
uniform highp vec4 PenThicknessA;
uniform highp vec4 PenThicknessB;
uniform highp vec4 PenColorA;
uniform highp vec4 PenColorB;
uniform highp vec4 BrushColorA;
uniform highp vec4 BrushColorB;
uniform sampler2D PenTextureA;
uniform sampler2D PenTextureB;
uniform sampler2D BrushTextureA;
uniform sampler2D BrushTextureB;
varying highp vec4 xlv_COLOR0;
varying highp vec3 xlv_TEXCOORD0;
varying highp vec2 xlv_TEXCOORD1;
varying highp vec3 xlv_TEXCOORD2;
void main ()
{
  highp vec4 tmpvar_1;
  if ((xlv_TEXCOORD2.x != 0.0)) {
    highp vec4 ColorB_2;
    highp vec4 ColorA_3;
    highp vec2 tmpvar_4;
    tmpvar_4.x = 0.5;
    tmpvar_4.y = xlv_TEXCOORD0.y;
    highp vec2 tmpvar_5;
    tmpvar_5.x = 0.5;
    tmpvar_5.y = xlv_TEXCOORD0.z;
    lowp vec4 tmpvar_6;
    tmpvar_6 = texture2D (PenTextureA, tmpvar_4);
    ColorA_3 = tmpvar_6;
    highp vec4 fadedColor_7;
    fadedColor_7.xyz = ColorA_3.xyz;
    fadedColor_7.w = 0.0;
    highp float tmpvar_8;
    tmpvar_8 = (1.0 - xlv_TEXCOORD0.x);
    highp vec4 tmpvar_9;
    tmpvar_9 = mix (fadedColor_7, ColorA_3, vec4(min ((
      min (xlv_TEXCOORD0.x, tmpvar_8)
     / 
      (PenThicknessA.w / ((PenThicknessA.w * 2.0) + (PenThicknessA.x - PenThicknessA.w)))
    ), 1.0)));
    ColorA_3 = tmpvar_9;
    lowp vec4 tmpvar_10;
    tmpvar_10 = texture2D (PenTextureB, tmpvar_5);
    ColorB_2 = tmpvar_10;
    highp vec4 fadedColor_11;
    fadedColor_11.xyz = ColorB_2.xyz;
    fadedColor_11.w = 0.0;
    highp vec4 tmpvar_12;
    tmpvar_12 = mix (fadedColor_11, ColorB_2, vec4(min ((
      min (xlv_TEXCOORD0.x, tmpvar_8)
     / 
      (PenThicknessB.w / ((PenThicknessB.w * 2.0) + (PenThicknessB.x - PenThicknessB.w)))
    ), 1.0)));
    ColorB_2 = tmpvar_12;
    highp vec4 tmpvar_13;
    tmpvar_13 = mix (tmpvar_9, tmpvar_12, xlv_TEXCOORD2.zzzz);
    highp vec4 tmpvar_14;
    if ((xlv_TEXCOORD2.y != 0.0)) {
      tmpvar_14 = xlv_COLOR0;
    } else {
      tmpvar_14 = mix (PenColorA, PenColorB, xlv_TEXCOORD2.zzzz);
    };
    tmpvar_1 = (tmpvar_13 * tmpvar_14);
  } else {
    lowp vec4 tmpvar_15;
    tmpvar_15 = texture2D (BrushTextureA, xlv_TEXCOORD1);
    highp vec4 tmpvar_16;
    tmpvar_16 = (BrushColorA * tmpvar_15);
    lowp vec4 tmpvar_17;
    tmpvar_17 = texture2D (BrushTextureB, xlv_TEXCOORD1);
    highp vec4 tmpvar_18;
    tmpvar_18 = (BrushColorB * tmpvar_17);
    highp vec4 tmpvar_19;
    if ((xlv_TEXCOORD2.y != 0.0)) {
      tmpvar_19 = xlv_COLOR0;
    } else {
      float tmpvar_20;
      if ((xlv_TEXCOORD0.x == 0.0)) {
        tmpvar_20 = 0.0;
      } else {
        tmpvar_20 = 1.0;
      };
      tmpvar_19 = mix (tmpvar_16, tmpvar_18, vec4(tmpvar_20));
    };
    tmpvar_1 = tmpvar_19;
  };
  gl_FragData[0] = tmpvar_1;
}

