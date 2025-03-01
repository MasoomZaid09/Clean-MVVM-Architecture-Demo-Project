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
attribute highp vec3 vPosition;
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
  tmpvar_3 = vPosition;
  highp vec3 tmpvar_6;
  highp vec4 tmpvar_7;
  highp vec3 tmpvar_8;
  highp vec3 tmpvar_9;
  highp vec4 tmpvar_10;
  highp vec4 tmpvar_11;
  highp vec4 tmpvar_12;
  highp vec3 tmpvar_13;
  tmpvar_13.x = matDataTransform[0].x;
  tmpvar_13.y = matDataTransform[1].y;
  tmpvar_13.z = matDataTransform[1].y;
  highp vec3 tmpvar_14;
  tmpvar_14.x = matDataTransform[0].w;
  tmpvar_14.y = matDataTransform[1].w;
  tmpvar_14.z = matDataTransform[1].w;
  tmpvar_4 = ((vTexCoord1 * tmpvar_13) + tmpvar_14);
  highp vec3 tmpvar_15;
  tmpvar_15.x = matDataTransform[0].x;
  tmpvar_15.y = matDataTransform[1].y;
  tmpvar_15.z = matDataTransform[1].y;
  highp vec3 tmpvar_16;
  tmpvar_16.x = matDataTransform[0].w;
  tmpvar_16.y = matDataTransform[1].w;
  tmpvar_16.z = matDataTransform[1].w;
  tmpvar_5 = ((vTexCoord3 * tmpvar_15) + tmpvar_16);
  if ((vTexCoord6.x == -1.0)) {
    highp vec4 tmpvar_17;
    highp float fIntersectionAmount_18;
    highp vec2 vIntersection_19;
    highp float tmpvar_20;
    tmpvar_20 = (tmpvar_4.z - tmpvar_4.y);
    highp float tmpvar_21;
    tmpvar_21 = (tmpvar_5.z - tmpvar_5.y);
    highp float tmpvar_22;
    tmpvar_22 = (tmpvar_20 * tmpvar_21);
    vIntersection_19 = vec2(0.0, 0.0);
    fIntersectionAmount_18 = 0.0;
    if ((tmpvar_22 < 0.0)) {
      highp vec3 tmpvar_23;
      highp float tmpvar_24;
      tmpvar_24 = (tmpvar_5.y - tmpvar_4.y);
      highp float tmpvar_25;
      tmpvar_25 = (tmpvar_4.x - tmpvar_5.x);
      highp float tmpvar_26;
      tmpvar_26 = ((tmpvar_24 * tmpvar_4.x) + (tmpvar_25 * tmpvar_4.y));
      highp float tmpvar_27;
      tmpvar_27 = (tmpvar_5.z - tmpvar_4.z);
      highp float tmpvar_28;
      tmpvar_28 = (tmpvar_4.x - tmpvar_5.x);
      highp float tmpvar_29;
      tmpvar_29 = ((tmpvar_27 * tmpvar_4.x) + (tmpvar_28 * tmpvar_4.z));
      highp float tmpvar_30;
      tmpvar_30 = ((tmpvar_24 * tmpvar_28) - (tmpvar_27 * tmpvar_25));
      if ((tmpvar_30 == 0.0)) {
        tmpvar_23 = vec3(3.402823e+38, 3.402823e+38, 0.0);
      } else {
        highp vec3 tmpvar_31;
        tmpvar_31.z = 1.0;
        tmpvar_31.x = (((tmpvar_28 * tmpvar_26) - (tmpvar_25 * tmpvar_29)) / tmpvar_30);
        tmpvar_31.y = (((tmpvar_24 * tmpvar_29) - (tmpvar_27 * tmpvar_26)) / tmpvar_30);
        tmpvar_23 = tmpvar_31;
      };
      vIntersection_19 = tmpvar_23.xy;
      fIntersectionAmount_18 = tmpvar_23.z;
    };
    fIntersectionAmount_18 = (fIntersectionAmount_18 * vTexCoord5.w);
    tmpvar_17.yzw = vec3(0.0, 0.0, 0.0);
    highp vec3 tmpvar_32;
    tmpvar_32.z = 0.0;
    tmpvar_32.xy = mix (mix (tmpvar_4.xy, tmpvar_4.xz, vTexCoord5.xx), mix (tmpvar_5.xy, tmpvar_5.xz, vTexCoord5.xx), vTexCoord5.yy);
    highp vec3 tmpvar_33;
    tmpvar_33.z = 0.0;
    tmpvar_33.xy = vIntersection_19;
    highp vec4 tmpvar_34;
    tmpvar_34.zw = vec2(0.0, 0.0);
    tmpvar_34.x = fIntersectionAmount_18;
    tmpvar_34.y = mix (clamp (tmpvar_20, 0.0, 1.0), clamp (tmpvar_21, 0.0, 1.0), vTexCoord5.z);
    tmpvar_17.x = vTexCoord2.x;
    tmpvar_6 = vec3(0.0, 0.0, 0.0);
    tmpvar_7 = tmpvar_17;
    tmpvar_8 = tmpvar_32;
    tmpvar_9 = tmpvar_33;
    tmpvar_10 = vec4(0.0, 0.0, 0.0, 0.0);
    tmpvar_11 = tmpvar_34;
    tmpvar_12 = vec4(0.0, 0.0, 0.0, 0.0);
  } else {
    highp vec3 tmpvar_35;
    tmpvar_35.z = 0.0;
    tmpvar_35.xy = vPosition.xy;
    highp vec3 tmpvar_36;
    tmpvar_36.z = 0.0;
    tmpvar_36.xy = vPosition.xz;
    tmpvar_3 = mix (tmpvar_35, tmpvar_36, vTexCoord6.xxx);
    highp vec3 tmpvar_37;
    tmpvar_37.z = 0.0;
    tmpvar_37.xy = tmpvar_4.xy;
    highp vec3 tmpvar_38;
    tmpvar_38.z = 0.0;
    tmpvar_38.xy = tmpvar_4.xz;
    tmpvar_4 = mix (tmpvar_37, tmpvar_38, vTexCoord6.xxx);
    highp vec3 tmpvar_39;
    tmpvar_39.z = 0.0;
    tmpvar_39.xy = tmpvar_5.xy;
    highp vec3 tmpvar_40;
    tmpvar_40.z = 0.0;
    tmpvar_40.xy = tmpvar_5.xz;
    tmpvar_5 = mix (tmpvar_39, tmpvar_40, vTexCoord6.xxx);
    highp vec4 tmpvar_41;
    tmpvar_41 = mix (PenThicknessA, PenThicknessB, vTexCoord6.xxxx);
    highp vec3 tmpvar_42;
    highp vec4 tmpvar_43;
    highp vec3 tmpvar_44;
    highp vec3 tmpvar_45;
    highp vec4 tmpvar_46;
    highp float fLerpEdge_47;
    highp float tmpvar_48;
    tmpvar_48 = vTexCoord5.x;
    fLerpEdge_47 = vTexCoord5.z;
    highp float tmpvar_49;
    tmpvar_49 = abs(vTexCoord5.w);
    if ((tmpvar_49 > 0.0)) {
      highp vec3 tmpvar_50;
      tmpvar_50.z = 0.0;
      tmpvar_50.xy = (tmpvar_5.xy - tmpvar_3.xy);
      highp vec3 tmpvar_51;
      tmpvar_51.z = 0.0;
      tmpvar_51.xy = (tmpvar_4.xy - tmpvar_5.xy);
      highp vec3 tmpvar_52;
      tmpvar_52 = ((tmpvar_50.yzx * tmpvar_51.zxy) - (tmpvar_50.zxy * tmpvar_51.yzx));
      if ((tmpvar_52.z > 0.0)) {
        fLerpEdge_47 = -(vTexCoord5.z);
      };
    };
    highp float tmpvar_53;
    tmpvar_53 = abs(vTexCoord5.y);
    tmpvar_46.x = (mix (vTexCoord2.z, vTexCoord4.z, tmpvar_53) / tmpvar_41.y);
    tmpvar_46.y = (mix (vTexCoord2.w, vTexCoord4.w, tmpvar_53) / tmpvar_41.y);
    tmpvar_44 = mix (tmpvar_4, tmpvar_5, vTexCoord5.yyy);
    tmpvar_45 = mix (tmpvar_5, tmpvar_4, vTexCoord5.yyy);
    highp vec4 tmpvar_54;
    tmpvar_54.w = 0.0;
    tmpvar_54.x = (tmpvar_41.x * fLerpEdge_47);
    tmpvar_54.y = tmpvar_48;
    tmpvar_54.z = tmpvar_41.x;
    if ((vTexCoord5.w > 0.0)) {
      tmpvar_44 = tmpvar_4;
      tmpvar_45 = tmpvar_3;
    };
    tmpvar_43.x = vTexCoord2.y;
    tmpvar_6 = tmpvar_42;
    tmpvar_7 = tmpvar_43;
    tmpvar_8 = tmpvar_44;
    tmpvar_9 = tmpvar_45;
    tmpvar_10 = tmpvar_46;
    tmpvar_11 = tmpvar_54;
    tmpvar_12 = vTexCoord6;
  };
  highp vec4 tmpvar_55;
  tmpvar_55.zw = vec2(0.0, 1.0);
  tmpvar_55.xy = tmpvar_6.xy;
  tmpvar_2 = (tmpvar_55 * vMatWorldViewProj_1);
  highp vec3 tmpvar_56;
  tmpvar_56 = vec3(0.0, 0.0, 0.0);
  highp vec4 tmpvar_57;
  highp float tmpvar_58;
  tmpvar_58 = abs(tmpvar_11.z);
  if ((tmpvar_58 > 0.0)) {
    highp vec4 outPosition_59;
    highp vec4 tmpvar_60;
    tmpvar_60.zw = vec2(0.0, 1.0);
    tmpvar_60.xy = tmpvar_8.xy;
    highp vec4 tmpvar_61;
    tmpvar_61 = (tmpvar_60 * matWorldViewProj);
    outPosition_59 = (tmpvar_61 / abs(tmpvar_61.w));
    highp vec4 tmpvar_62;
    tmpvar_62.zw = vec2(0.0, 1.0);
    tmpvar_62.xy = tmpvar_9.xy;
    highp vec4 tmpvar_63;
    tmpvar_63 = (tmpvar_62 * matWorldViewProj);
    highp vec2 tmpvar_64;
    tmpvar_64 = normalize(((tmpvar_63 / 
      abs(tmpvar_63.w)
    ).xy - outPosition_59.xy));
    outPosition_59.x = (outPosition_59.x - ((tmpvar_11.x * screenSize.z) * tmpvar_64.y));
    outPosition_59.y = (outPosition_59.y + ((tmpvar_11.x * screenSize.w) * tmpvar_64.x));
    tmpvar_57 = outPosition_59;
  } else {
    highp vec4 finalPosition_65;
    highp vec4 tmpvar_66;
    tmpvar_66.zw = vec2(0.0, 1.0);
    tmpvar_66.xy = tmpvar_8.xy;
    highp vec4 tmpvar_67;
    tmpvar_67 = (tmpvar_66 * matWorldViewProj);
    highp vec4 tmpvar_68;
    tmpvar_68.zw = vec2(0.0, 1.0);
    tmpvar_68.xy = tmpvar_9.xy;
    highp vec4 tmpvar_69;
    tmpvar_69 = (tmpvar_68 * matWorldViewProj);
    finalPosition_65.xyw = mix ((tmpvar_67 / abs(tmpvar_67.w)), (tmpvar_69 / abs(tmpvar_69.w)), tmpvar_11.xxxx).xyw;
    finalPosition_65.z = 0.25;
    tmpvar_57 = finalPosition_65;
  };
  if ((tmpvar_11.z > 0.0)) {
    tmpvar_56.x = (2.0 / tmpvar_11.z);
  } else {
    tmpvar_56.x = 0.0;
  };
  tmpvar_56.y = (1.0/(tmpvar_56.x));
  tmpvar_56.z = tmpvar_12.x;
  highp vec3 tmpvar_70;
  tmpvar_70.x = tmpvar_11.y;
  tmpvar_70.y = tmpvar_10.x;
  tmpvar_70.z = tmpvar_10.y;
  highp vec2 _position_71;
  _position_71 = (vec2(0.5, 0.5) * (tmpvar_57.xy + vec2(1.0, 1.0)));
  highp vec2 tmpvar_72;
  highp vec4 tmpvar_73;
  tmpvar_73.zw = vec2(0.0, 1.0);
  tmpvar_73.xy = _position_71;
  tmpvar_72 = (matTexCoordTransform * tmpvar_73).xy;
  _position_71 = tmpvar_72;
  highp vec2 tmpvar_74;
  tmpvar_74.y = 0.5;
  tmpvar_74.x = (PaletteSize.z * (tmpvar_7.x + 0.5));
  highp vec4 tmpvar_75;
  lowp vec4 tmpvar_76;
  tmpvar_76 = texture2DLod (PaletteTexture, tmpvar_74, 0.0);
  tmpvar_75 = tmpvar_76;
  highp float tmpvar_77;
  tmpvar_77 = sqrt(dot (tmpvar_75, tmpvar_75));
  highp float tmpvar_78;
  if ((tmpvar_77 > 0.0)) {
    tmpvar_78 = 1.0;
  } else {
    tmpvar_78 = 0.0;
  };
  tmpvar_56.y = tmpvar_78;
  tmpvar_2.xzw = tmpvar_57.xzw;
  tmpvar_2.y = -(tmpvar_57.y);
  gl_Position = tmpvar_2;
  xlv_COLOR0 = tmpvar_75;
  xlv_TEXCOORD0 = tmpvar_70;
  xlv_TEXCOORD1 = tmpvar_72;
  xlv_TEXCOORD2 = tmpvar_56;
}

