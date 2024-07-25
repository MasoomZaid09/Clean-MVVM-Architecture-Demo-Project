uniform highp mat4 matProj;
uniform highp vec4 screenSize;
uniform highp mat4 matWorldView;
uniform highp mat4 matWorldViewProj;
uniform highp mat4 matDataTransform;
uniform highp mat4 matTexCoordTransform;
uniform highp vec4 PaletteSize;
uniform highp vec4 PenThicknessA;
uniform highp vec4 PenThicknessB;
uniform sampler2D PaletteTexture;
attribute highp vec3 vTexCoord1;
attribute highp vec4 vTexCoord2;
attribute highp vec3 vTexCoord3;
attribute highp vec4 vTexCoord4;
attribute highp vec4 vTexCoord5;
attribute highp vec4 vTexCoord6;
varying highp vec4 xlv_COLOR0;
varying highp vec3 xlv_TEXCOORD0;
varying highp vec2 xlv_TEXCOORD1;
varying highp vec3 xlv_TEXCOORD2;
void main ()
{
  highp mat4 vMatWorldViewProj_1;
  highp vec4 tmpvar_2;
  vMatWorldViewProj_1 = (matWorldView * matProj);
  highp vec3 tmpvar_3;
  highp vec3 tmpvar_4;
  highp vec3 tmpvar_5;
  highp vec4 tmpvar_6;
  highp vec3 tmpvar_7;
  highp vec3 tmpvar_8;
  highp vec4 tmpvar_9;
  highp vec4 tmpvar_10;
  highp vec4 tmpvar_11;
  highp vec3 tmpvar_12;
  tmpvar_12.x = matDataTransform[0].x;
  tmpvar_12.y = matDataTransform[1].y;
  tmpvar_12.z = matDataTransform[1].y;
  highp vec3 tmpvar_13;
  tmpvar_13.x = matDataTransform[0].w;
  tmpvar_13.y = matDataTransform[1].w;
  tmpvar_13.z = matDataTransform[1].w;
  tmpvar_3 = ((vTexCoord1 * tmpvar_12) + tmpvar_13);
  highp vec3 tmpvar_14;
  tmpvar_14.x = matDataTransform[0].x;
  tmpvar_14.y = matDataTransform[1].y;
  tmpvar_14.z = matDataTransform[1].y;
  highp vec3 tmpvar_15;
  tmpvar_15.x = matDataTransform[0].w;
  tmpvar_15.y = matDataTransform[1].w;
  tmpvar_15.z = matDataTransform[1].w;
  tmpvar_4 = ((vTexCoord3 * tmpvar_14) + tmpvar_15);
  if ((vTexCoord6.x == -1.0)) {
    tmpvar_4.yz = tmpvar_3.yz;
    highp vec4 tmpvar_16;
    highp float fIntersectionAmount_17;
    highp vec2 vIntersection_18;
    highp float tmpvar_19;
    tmpvar_19 = (tmpvar_3.z - tmpvar_3.y);
    highp float tmpvar_20;
    tmpvar_20 = (tmpvar_3.z - tmpvar_3.y);
    highp float tmpvar_21;
    tmpvar_21 = (tmpvar_19 * tmpvar_20);
    vIntersection_18 = vec2(0.0, 0.0);
    fIntersectionAmount_17 = 0.0;
    if ((tmpvar_21 < 0.0)) {
      highp vec3 tmpvar_22;
      highp float tmpvar_23;
      tmpvar_23 = (tmpvar_3.y - tmpvar_3.y);
      highp float tmpvar_24;
      tmpvar_24 = (tmpvar_3.x - tmpvar_4.x);
      highp float tmpvar_25;
      tmpvar_25 = ((tmpvar_23 * tmpvar_3.x) + (tmpvar_24 * tmpvar_3.y));
      highp float tmpvar_26;
      tmpvar_26 = (tmpvar_3.z - tmpvar_3.z);
      highp float tmpvar_27;
      tmpvar_27 = (tmpvar_3.x - tmpvar_4.x);
      highp float tmpvar_28;
      tmpvar_28 = ((tmpvar_26 * tmpvar_3.x) + (tmpvar_27 * tmpvar_3.z));
      highp float tmpvar_29;
      tmpvar_29 = ((tmpvar_23 * tmpvar_27) - (tmpvar_26 * tmpvar_24));
      if ((tmpvar_29 == 0.0)) {
        tmpvar_22 = vec3(3.402823e+38, 3.402823e+38, 0.0);
      } else {
        highp vec3 tmpvar_30;
        tmpvar_30.z = 1.0;
        tmpvar_30.x = (((tmpvar_27 * tmpvar_25) - (tmpvar_24 * tmpvar_28)) / tmpvar_29);
        tmpvar_30.y = (((tmpvar_23 * tmpvar_28) - (tmpvar_26 * tmpvar_25)) / tmpvar_29);
        tmpvar_22 = tmpvar_30;
      };
      vIntersection_18 = tmpvar_22.xy;
      fIntersectionAmount_17 = tmpvar_22.z;
    };
    fIntersectionAmount_17 = (fIntersectionAmount_17 * vTexCoord5.w);
    tmpvar_16.yzw = vec3(0.0, 0.0, 0.0);
    highp vec3 tmpvar_31;
    tmpvar_31.z = 0.0;
    tmpvar_31.xy = mix (mix (tmpvar_3.xy, tmpvar_3.xz, vTexCoord5.xx), mix (tmpvar_4.xy, tmpvar_4.xz, vTexCoord5.xx), vTexCoord5.yy);
    highp vec3 tmpvar_32;
    tmpvar_32.z = 0.0;
    tmpvar_32.xy = vIntersection_18;
    highp vec4 tmpvar_33;
    tmpvar_33.zw = vec2(0.0, 0.0);
    tmpvar_33.x = fIntersectionAmount_17;
    tmpvar_33.y = mix (clamp (tmpvar_19, 0.0, 1.0), clamp (tmpvar_20, 0.0, 1.0), vTexCoord5.z);
    tmpvar_16.x = vTexCoord2.x;
    tmpvar_5 = vec3(0.0, 0.0, 0.0);
    tmpvar_6 = tmpvar_16;
    tmpvar_7 = tmpvar_31;
    tmpvar_8 = tmpvar_32;
    tmpvar_9 = vec4(0.0, 0.0, 0.0, 0.0);
    tmpvar_10 = tmpvar_33;
    tmpvar_11 = vec4(0.0, 0.0, 0.0, 0.0);
  } else {
    highp vec3 tmpvar_34;
    tmpvar_34.z = 0.0;
    tmpvar_34.xy = tmpvar_3.xy;
    highp vec3 tmpvar_35;
    tmpvar_35.z = 0.0;
    tmpvar_35.xy = tmpvar_3.xz;
    tmpvar_3 = mix (tmpvar_34, tmpvar_35, vTexCoord6.xxx);
    highp vec3 tmpvar_36;
    tmpvar_36.z = 0.0;
    tmpvar_36.xy = tmpvar_4.xy;
    highp vec3 tmpvar_37;
    tmpvar_37.z = 0.0;
    tmpvar_37.xy = tmpvar_4.xz;
    tmpvar_4 = mix (tmpvar_36, tmpvar_37, vTexCoord6.xxx);
    highp vec4 tmpvar_38;
    tmpvar_38 = mix (PenThicknessA, PenThicknessB, vTexCoord6.xxxx);
    highp vec3 tmpvar_39;
    highp vec3 tmpvar_40;
    tmpvar_39 = tmpvar_3;
    tmpvar_40 = tmpvar_4;
    highp vec3 tmpvar_41;
    highp vec4 tmpvar_42;
    highp vec4 tmpvar_43;
    highp vec4 tmpvar_44;
    highp float tmpvar_45;
    tmpvar_45 = vTexCoord5.x;
    highp float tmpvar_46;
    tmpvar_46 = abs(vTexCoord5.w);
    if ((tmpvar_46 == 0.0)) {
      tmpvar_40.y = tmpvar_3.y;
      tmpvar_40.x = (tmpvar_4.x - ((0.5 * tmpvar_38.x) * sign(
        (tmpvar_4.x - tmpvar_3.x)
      )));
      tmpvar_39.x = (tmpvar_3.x - ((0.5 * tmpvar_38.x) * sign(
        (tmpvar_40.x - tmpvar_3.x)
      )));
    } else {
      tmpvar_39.x = tmpvar_40.x;
      tmpvar_40.y = (tmpvar_40.y - ((0.5 * tmpvar_38.x) * sign(
        (tmpvar_40.y - tmpvar_3.y)
      )));
      tmpvar_39.y = (tmpvar_3.y - ((0.5 * tmpvar_38.x) * sign(
        (tmpvar_40.y - tmpvar_3.y)
      )));
    };
    highp float tmpvar_47;
    tmpvar_47 = abs(vTexCoord5.y);
    tmpvar_43.x = (mix (vTexCoord2.z, vTexCoord4.z, tmpvar_47) / tmpvar_38.y);
    tmpvar_43.y = (mix (vTexCoord2.w, vTexCoord4.w, tmpvar_47) / tmpvar_38.y);
    highp vec4 tmpvar_48;
    tmpvar_48.w = 0.0;
    tmpvar_48.x = (tmpvar_38.x * vTexCoord5.z);
    tmpvar_48.y = tmpvar_45;
    tmpvar_48.z = tmpvar_38.x;
    tmpvar_44.xzw = tmpvar_48.xzw;
    tmpvar_44.y = 0.5;
    tmpvar_42.x = vTexCoord2.y;
    tmpvar_5 = tmpvar_41;
    tmpvar_6 = tmpvar_42;
    tmpvar_7 = mix (tmpvar_39, tmpvar_40, vTexCoord5.yyy);
    tmpvar_8 = mix (tmpvar_40, tmpvar_39, vTexCoord5.yyy);
    tmpvar_9 = tmpvar_43;
    tmpvar_10 = tmpvar_44;
    tmpvar_11 = vTexCoord6;
  };
  highp vec4 tmpvar_49;
  tmpvar_49.zw = vec2(0.0, 1.0);
  tmpvar_49.xy = tmpvar_5.xy;
  tmpvar_2 = (tmpvar_49 * vMatWorldViewProj_1);
  highp vec3 tmpvar_50;
  tmpvar_50 = vec3(0.0, 0.0, 0.0);
  highp vec4 tmpvar_51;
  highp float tmpvar_52;
  tmpvar_52 = abs(tmpvar_10.z);
  if ((tmpvar_52 > 0.0)) {
    highp vec4 outPosition_53;
    highp vec4 tmpvar_54;
    tmpvar_54.zw = vec2(0.0, 1.0);
    tmpvar_54.xy = tmpvar_7.xy;
    highp vec4 tmpvar_55;
    tmpvar_55 = (tmpvar_54 * matWorldViewProj);
    outPosition_53 = (tmpvar_55 / abs(tmpvar_55.w));
    highp vec4 tmpvar_56;
    tmpvar_56.zw = vec2(0.0, 1.0);
    tmpvar_56.xy = tmpvar_8.xy;
    highp vec4 tmpvar_57;
    tmpvar_57 = (tmpvar_56 * matWorldViewProj);
    highp vec2 tmpvar_58;
    tmpvar_58 = normalize(((tmpvar_57 / 
      abs(tmpvar_57.w)
    ).xy - outPosition_53.xy));
    outPosition_53.x = (outPosition_53.x - ((tmpvar_10.x * screenSize.z) * tmpvar_58.y));
    outPosition_53.y = (outPosition_53.y + ((tmpvar_10.x * screenSize.w) * tmpvar_58.x));
    tmpvar_51 = outPosition_53;
  } else {
    highp vec4 finalPosition_59;
    highp vec4 tmpvar_60;
    tmpvar_60.zw = vec2(0.0, 1.0);
    tmpvar_60.xy = tmpvar_7.xy;
    highp vec4 tmpvar_61;
    tmpvar_61 = (tmpvar_60 * matWorldViewProj);
    highp vec4 tmpvar_62;
    tmpvar_62.zw = vec2(0.0, 1.0);
    tmpvar_62.xy = tmpvar_8.xy;
    highp vec4 tmpvar_63;
    tmpvar_63 = (tmpvar_62 * matWorldViewProj);
    finalPosition_59.xyw = mix ((tmpvar_61 / abs(tmpvar_61.w)), (tmpvar_63 / abs(tmpvar_63.w)), tmpvar_10.xxxx).xyw;
    finalPosition_59.z = 0.25;
    tmpvar_51 = finalPosition_59;
  };
  if ((tmpvar_10.z > 0.0)) {
    tmpvar_50.x = (2.0 / tmpvar_10.z);
  } else {
    tmpvar_50.x = 0.0;
  };
  tmpvar_50.y = (1.0/(tmpvar_50.x));
  tmpvar_50.z = tmpvar_11.x;
  highp vec3 tmpvar_64;
  tmpvar_64.x = tmpvar_10.y;
  tmpvar_64.y = tmpvar_9.x;
  tmpvar_64.z = tmpvar_9.y;
  highp vec2 _position_65;
  _position_65 = (vec2(0.5, 0.5) * (tmpvar_51.xy + vec2(1.0, 1.0)));
  highp vec2 tmpvar_66;
  highp vec4 tmpvar_67;
  tmpvar_67.zw = vec2(0.0, 1.0);
  tmpvar_67.xy = _position_65;
  tmpvar_66 = (matTexCoordTransform * tmpvar_67).xy;
  _position_65 = tmpvar_66;
  highp vec2 tmpvar_68;
  tmpvar_68.y = 0.5;
  tmpvar_68.x = (PaletteSize.z * (tmpvar_6.x + 0.5));
  highp vec4 tmpvar_69;
  lowp vec4 tmpvar_70;
  tmpvar_70 = texture2DLod (PaletteTexture, tmpvar_68, 0.0);
  tmpvar_69 = tmpvar_70;
  highp float tmpvar_71;
  tmpvar_71 = sqrt(dot (tmpvar_69, tmpvar_69));
  highp float tmpvar_72;
  if ((tmpvar_71 > 0.0)) {
    tmpvar_72 = 1.0;
  } else {
    tmpvar_72 = 0.0;
  };
  tmpvar_50.y = tmpvar_72;
  tmpvar_2.xzw = tmpvar_51.xzw;
  tmpvar_2.y = -(tmpvar_51.y);
  gl_Position = tmpvar_2;
  xlv_COLOR0 = tmpvar_69;
  xlv_TEXCOORD0 = tmpvar_64;
  xlv_TEXCOORD1 = tmpvar_66;
  xlv_TEXCOORD2 = tmpvar_50;
}

