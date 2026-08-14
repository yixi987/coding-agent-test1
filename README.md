# 项目依赖结构

## 项目概览

这是一个不使用包管理器或构建工具的单模块 Java 项目。

```text
test.iml (IntelliJ 模块)
└── src/
    └── Main.java
        ├── main(String[])
        └── binarySearch(int[], int)
```

`main` 与 `binarySearch` 位于同一个默认包类中，`main` 直接调用
`binarySearch`，不存在其他项目内部模块依赖。

## 依赖清单

| 类型 | 依赖 | 来源 | 说明 |
| --- | --- | --- | --- |
| 运行时 | Java 标准库 | `src/Main.java` | 使用 `System`、`Integer`、`String` 和数组等 JDK API |
| 开发时 | JDK 21 | `.idea/misc.xml` | IntelliJ 项目配置的 SDK 与语言级别 |
| 第三方 | 无 | — | 没有 Maven、Gradle 或其他依赖清单 |
| 测试 | 无 | — | 没有测试源码或测试框架 |

因此项目没有需要解析的直接或传递第三方依赖，运行时依赖边界就是
JDK。已提交的 `src/Main.class` 是 Java 17 字节码，而 IDE 配置为 JDK
21；源码也可使用 JDK 17 编译。

## 构建和运行

项目没有构建脚本，可直接使用 JDK 工具：

```bash
mkdir -p out
javac -d out src/Main.java
java -cp out Main 1 2 3 4 5 5
```

示例输出：

```text
Result index: 4
```

## 当前限制与风险

- 没有构建清单或 wrapper，JDK 版本无法由项目自动统一。
- IDE 配置（JDK 21）与已提交字节码（Java 17）不一致。
- `src/Main.class` 是构建产物且位于源码目录，可能与源码发生漂移。
- 代码使用默认包，不利于项目扩展后的模块边界管理。
- 没有自动化测试或 CI，依赖和行为变更无法自动验证。
