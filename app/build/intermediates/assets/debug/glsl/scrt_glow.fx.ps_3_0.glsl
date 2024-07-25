precision mediump float;
uniform highp vec4 screenSize;
uniform highp vec4 EffectParams;
uniform highp vec4 EffectColor;
uniform sampler2D DiffuseTexture;
varying highp vec4 xlv_TEXCOORD0;
void main ()
{
  highp vec2 texCoord_1;
  texCoord_1.x = xlv_TEXCOORD0.x;
  highp float Z_3;
  highp vec3 final_colour_4;
  highp float kernel_5[7];
  highp vec4 fragColor_6;
  texCoord_1.y = (1.0 - xlv_TEXCOORD0.y);
  final_colour_4 = vec3(0.0, 0.0, 0.0);
  kernel_5[3] = 0.05699143;
  kernel_5[3] = 0.05699143;
  kernel_5[(3 - 1)] = 0.05641284;
  kernel_5[(3 + 1)] = 0.05641284;
  kernel_5[(3 - 2)] = 0.05471208;
  kernel_5[(3 + 2)] = 0.05471208;
  kernel_5[(3 - 3)] = 0.05199066;
  kernel_5[(3 + 3)] = 0.05199066;
  Z_3 = kernel_5[0];
  Z_3 = (Z_3 + kernel_5[1]);
  Z_3 = (Z_3 + kernel_5[2]);
  Z_3 = (Z_3 + kernel_5[3]);
  Z_3 = (Z_3 + kernel_5[4]);
  Z_3 = (Z_3 + kernel_5[5]);
  Z_3 = (Z_3 + kernel_5[6]);
  for (highp int i_2 = -3; i_2 <= 3; i_2++) {
    highp vec2 tmpvar_7;
    tmpvar_7.x = float(i_2);
    tmpvar_7.y = -3.0;
    lowp vec4 tmpvar_8;
    highp vec2 P_9;
    P_9 = (texCoord_1 + (tmpvar_7 / screenSize.xy));
    tmpvar_8 = texture2D (DiffuseTexture, P_9);
    final_colour_4 = (final_colour_4 + ((kernel_5[0] * kernel_5[
      (3 + i_2)
    ]) * tmpvar_8.xyz));
    highp vec2 tmpvar_10;
    tmpvar_10.x = float(i_2);
    tmpvar_10.y = -2.0;
    lowp vec4 tmpvar_11;
    highp vec2 P_12;
    P_12 = (texCoord_1 + (tmpvar_10 / screenSize.xy));
    tmpvar_11 = texture2D (DiffuseTexture, P_12);
    final_colour_4 = (final_colour_4 + ((kernel_5[1] * kernel_5[
      (3 + i_2)
    ]) * tmpvar_11.xyz));
    highp vec2 tmpvar_13;
    tmpvar_13.x = float(i_2);
    tmpvar_13.y = -1.0;
    lowp vec4 tmpvar_14;
    highp vec2 P_15;
    P_15 = (texCoord_1 + (tmpvar_13 / screenSize.xy));
    tmpvar_14 = texture2D (DiffuseTexture, P_15);
    final_colour_4 = (final_colour_4 + ((kernel_5[2] * kernel_5[
      (3 + i_2)
    ]) * tmpvar_14.xyz));
    highp vec2 tmpvar_16;
    tmpvar_16.x = float(i_2);
    tmpvar_16.y = 0.0;
    lowp vec4 tmpvar_17;
    highp vec2 P_18;
    P_18 = (texCoord_1 + (tmpvar_16 / screenSize.xy));
    tmpvar_17 = texture2D (DiffuseTexture, P_18);
    final_colour_4 = (final_colour_4 + ((kernel_5[3] * kernel_5[
      (3 + i_2)
    ]) * tmpvar_17.xyz));
    highp vec2 tmpvar_19;
    tmpvar_19.x = float(i_2);
    tmpvar_19.y = 1.0;
    lowp vec4 tmpvar_20;
    highp vec2 P_21;
    P_21 = (texCoord_1 + (tmpvar_19 / screenSize.xy));
    tmpvar_20 = texture2D (DiffuseTexture, P_21);
    final_colour_4 = (final_colour_4 + ((kernel_5[4] * kernel_5[
      (3 + i_2)
    ]) * tmpvar_20.xyz));
    highp vec2 tmpvar_22;
    tmpvar_22.x = float(i_2);
    tmpvar_22.y = 2.0;
    lowp vec4 tmpvar_23;
    highp vec2 P_24;
    P_24 = (texCoord_1 + (tmpvar_22 / screenSize.xy));
    tmpvar_23 = texture2D (DiffuseTexture, P_24);
    final_colour_4 = (final_colour_4 + ((kernel_5[5] * kernel_5[
      (3 + i_2)
    ]) * tmpvar_23.xyz));
    highp vec2 tmpvar_25;
    tmpvar_25.x = float(i_2);
    tmpvar_25.y = 3.0;
    lowp vec4 tmpvar_26;
    highp vec2 P_27;
    P_27 = (texCoord_1 + (tmpvar_25 / screenSize.xy));
    tmpvar_26 = texture2D (DiffuseTexture, P_27);
    final_colour_4 = (final_colour_4 + ((kernel_5[6] * kernel_5[
      (3 + i_2)
    ]) * tmpvar_26.xyz));
  };
  highp vec4 tmpvar_28;
  tmpvar_28.w = 1.0;
  tmpvar_28.xyz = (final_colour_4 / (Z_3 * Z_3));
  fragColor_6.xyz = tmpvar_28.xyz;
  fragColor_6.w = (((tmpvar_28.x + tmpvar_28.y) + tmpvar_28.z) / 3.0);
  fragColor_6.xyz = mix (tmpvar_28.xyz, (fragColor_6.w * EffectColor.xyz), EffectParams.zzz);
  fragColor_6.xyz = (EffectParams.y * fragColor_6.xyz);
  gl_FragData[0] = fragColor_6;
}

