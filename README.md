# HOW TO USE

## To start, initialize a database and set a query to it

```
ImageBase ib = new ImageBase();
ImageBase ib = new ImageBase("NAME_HERE"); // creates a ImageBase with specified name
ImageQuery iq = new ImageQuery(ib);
```

## ImageQuery commands
### to set dimensions for your table
```
iq.setDimension(x, y); // default will be 100 x 100 
```
keep in mind the created table will be on this dimension and is currently static (cannot be changed dynamically)

### to create a table for your imageBase
```
iq.write("Hello, this is a basic text! but there is a given name here!", "TABLE_NAME");
iq.setTableName("TABLE_NAME");
iq.write("Hello this is a basic text!");
```

### to read a table from your imageBase
```
ArrayList<String> datas = iq.read("TABLE_NAME");
datas.get(0);

iq.setTableName("TABLE_NAME");
ArrayList<String> datas = iq.read();
datas.get(0);
```
make sure that the given table_name exists else nothing returns,

