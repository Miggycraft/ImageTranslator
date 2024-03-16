# HOW TO USE

## To start, initialize a database and set a query to it

```
ImageBase ib = new ImageBase();
ImageBase ib = new ImageBase("NAME_HERE"); // creates a ImageBase with specified name
ImageQuery iq = new ImageQuery(ib);
```

## ImageQuery commands
### to create a table for your imageBase
```
iq.write("Hello, this is a basic text!");
iq.write("Hello, this is a basic text! but there is a given name here!", "TABLE_NAME");
```

### to read a table from your imageBase
```
ArrayList<String> datas = iq.read("TABLE_NAME");
datas.get(0);
```
make sure that the given table_name exists else nothing returns,

### to set dimensions for your table
```
iq.setDimension(x, y); // default will be 100 x 100 
```

### to read your TableImages
```
iq.read("TABLE_NAME");
```
