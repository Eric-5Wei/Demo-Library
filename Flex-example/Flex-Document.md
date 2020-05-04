# 1.Flex布局原理

## 1.1布局原理

flex是flexble Box的缩写，意为“弹性布局”，用来为盒状模型提供最大的灵活性，任何一个容器都可以指定为flex布局。

- 当我们为父盒子设为flex布局以后，子元素的float、clear和vertical-align属性将失效。
- 伸缩布局=弹性布局=伸缩盒布局=弹性盒布局=flex布局

采用 Flex 布局的元素，称为 Flex 容器（flex container），简称“容器”。他所有子元素自动成为容器成员，简称为 Flex 项目（flex item）,简称“项目”。

- 体验中的div就是flex父容器
- 体验中的span就是子容器flex项目
- 子容器可以横向排列也可以纵向排列

总结flex布局原理：
就是通过给父盒子添加flex属性，来控制盒子的位置和排列方式

# 2.flex布局父项常见属性

## 2.1 常见父项属性

以下有6个属性是对父元素设置的

- flex-direction: 设置主轴的方向
- justify-content: 设置主轴上的子元素排列方式
- flex-wrap: 设置子元素是否换行
- align-content: 设置侧轴上的子元素排列方式（多行）
- align-items: 设置侧轴上的子元素排列方式（单行）
- flex-flow: 复合属性，相当于同时设置了flex-direction和flex-wrap

## 2.2 flex-direction 设置主轴的方向

### 1.主轴与侧轴
在 flex 布局中，是分为主轴和侧轴两个方向，同时的叫法有：行和列、x轴和y轴

- 默认主轴方向就是x轴方向，水平向右
- 默认侧轴方向就是y轴方向，水平向下

### 2.属性值
flex-direction属性决定主轴的方向（即项目的排列方向）

注意：主轴和侧轴是会变化的，就看flex-direction设置谁为主轴，剩下的就是侧轴。而我们的子元素是跟着主轴来排列的

属性值 | 说明
---|---
row | 默认值从左到右
row-reverse | 从右到左
column | 从上到下
column-reverse | 从下到上

## 2.3 justify-content 设置主轴上的子元素排列方式

justify-content属性定义了项目在主轴上的对齐方式

注意：使用这个属性之前一定要确认好主轴是哪个

属性值 | 说明
---|---
flex-start | 默认值从头部开始 如果主轴是x轴，则从左到右
flex-end | 从尾部开始排列
center | 在主轴居中对齐（如果主轴是x轴则水平居中）
space-around | 平分剩余空间
space-between | 先从两边沾边再平分剩余空间（重要）

## 2.4 flex-wrap 设置子元素是否换行

默认情况下，项目都是排在一条线（又称“轴线”）上。flex-wrap属性定义，flex布局中默认是不换行的。

属性值 | 说明
---|---
nowarp | 默认值，不换行
warp | 换行

## 2.5 align-items 设置侧轴上的子元素排列方式（单行）

该属性是控制子项在侧轴（默认是y轴）上的排列方式 在子项单项的是时候使用

属性值 | 说明
---|---
flex-start | 默认值 从上到下
flex-end | 从下到上
center | 挤在一起居中（垂直居中）
stretch | 拉伸

## 2.6 align-content 设置侧轴上的子元素排列方式（多行）

设置子项在侧轴上的排列方式并且只能用于子项出现换行的情况（多行），在单行下是没有效果的。

属性值 | 说明
---|---
flex-start | 默认值在侧轴的头部开始排列
flex-end | 在侧轴的尾部开始排列
center | 在侧轴中间显示
space-around | 子项在侧轴平分剩余空间
space-between | 子项在侧轴先分布在两头，再平分剩余空间
stretch | 设置子项元素高度平分父元素高度

### align-content 和 align-items 区别

- align-items 适用于单行情况下，只有上对齐、下对齐、居中和拉伸
- align-content 适用于换行（多行）的情况下（单行情况下无效），可以设置上对齐、下对齐、居中、拉伸以及平均分配剩余空间等属性值。
- 总结就是单行找align-items 多行找align-content

## 2.7 flex-flow 复合属性

flex-flow 属性是 flex-direction 和 flex-wrap 属性的复合属性

```
flex-flow:row wrap;
```

# 3.flex布局子项常见属性

- flex子项目占的份数
- align-self控制子项自己在侧轴的排列方式
- order属性定义子项的排序顺序（前后顺序）

## 3.1 flex属性

flex 属性定义子项目分配剩余空间，用flex来表示占多少份数。

```
.item {
    flex: <number>; /* default 0 */
}
```

## 3.2 align-self 控制子项自己在侧轴上的排列方式

align-self属性允许单个项目有其它项目不一样的对齐方式，可以覆盖align-items属性。

默认值为auto，表示继承父元素的align-items属性，如果没有父元素，则等同于stretch。

```
div span:nth-child(3) {
        /* 设置自己在侧轴上的排列方式 */
        align-self: flex-end;
    }
```

## 3.3 order 属性定义项目的排列顺序

数值越小，排列越靠前，默认为0.

注意：和z-index不一样。