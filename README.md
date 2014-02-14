microtable
==========

Java simple table class. 
Current implementation much faster for operations with rows, not columns

## Features 

- Add / Remove / Move columns and rows
- Get / Set cells values
- Based on template
- Rotate table (columns becomes rows)
- Get rows and columns

## Simple and documented API
- Table class implements interface, so somebody can change implementation
- Each function in interface is documented

## Usage
Use import
```java
import org.reddec.microtable.Table;
```

#### Indexes
Access cell by row and column (i,j)
```java
int i,j;
table.setCell(i,j, <value> );
```
   |  0  |  1  | ... | N
---| --- | --- | --- | ---
 **0** |     |     |     | 
 **1** |     |     |     |
    ...|     |     |     |
 **M** |     |     |     |

```i = 0 .. M```
```j = 0 .. N```

#### Rows
Get row

```java
List row = table.getRow(1)
```
   |  0  |  1  | ... | N
---| --- | --- | --- | ---
 **0** |  a0 |  a1 | ... | aN
 **1** |  b0 |  b1 | ... | bN
...| ... | ... | ... | ...

```row``` will be

   |     |     |     | 
---| --- | --- | --- |
 b0|  b1 | ... | bN  |
 
 
#### Columns 
Get column


```java
List column = table.getColumn(1)
```
   |  0  |  1  | ... | N
---| --- | --- | --- | ---
 **0** |  a0 |  a1 | ... | aN
 **1** |  b0 |  b1 | ... | bN
...| ... | ... | ... | ...

```column``` will be

   |     |     |
---| --- | --- |
 a1|  b1 | ... |


## Examples

#### Create table with string cells
```java
Table<String> table = new Table<String>();
```
#### Add 3 columns
```java
Table<String> table = new Table<String>();
table.addColumns(3);
```
or with default value "Spam" for each new cell
```java
table.addColumns(3,"Spam");
```

#### Table 3x3 with default value "Foo"
```java
Table<String> table = new Table<String>();
table.addColumns(3);
table.addRows(3, "Foo");
```
|     |     |     |
| --- | --- | --- |
| Foo | Foo | Foo |
| Foo | Foo | Foo |
| Foo | Foo | Foo |

#### Table 3x3 with custom values
```java
Table<String> table = new Table<String>();
table.addColumns(3);
table.addRows(3, "Foo");
table.setCell(0,2,"TOP");
table.setCell(2,0,"BOT");
```
|     |     |     |
| --- | --- | --- |
| Foo | Foo | **TOP** |
| Foo | Foo | Foo |
| **BOT** | Foo | Foo |

#### Table 3x5. Custom values and rotate
```java
Table<String> table = new Table<String>();
table.addColumns(5);
table.addRows(3, "Foo");
table.setCell(0,4,"TOP");
table.setCell(2,0,"BOT");

Table<String> table_rotated = table.rotateTable();
```
Source ```table```

|         |     |     |     |         |
| ------- | --- | --- | --- | ------- |
| Foo     | Foo | Foo | Foo | **TOP** |
| Foo     | Foo | Foo | Foo | Foo     |
| **BOT** | Foo | Foo | Foo | Foo     | 


Rotated ```table_rotated```

|          |     |         |
| -------- | --- | ------- |
| **BOT*** | Foo | Foo     |
| Foo      | Foo | Foo     |
| Foo      | Foo | Foo     |
| Foo      | Foo | Foo     |
| Foo      | Foo | **TOP** |

