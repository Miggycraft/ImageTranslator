#HOW TO USE

To start, initialize a database and set a query to it

```
ImageBase ib = new ImageBase();
ImageQuery iq = new ImageQuery(ib);
```

functions that help your ImageBase

```
ImageBase ib = new ImageBase("NAME_HERE"); // creates a ImageBase with specified name
ib.setName("NAME_HERE"); // alternative of the previous one
```

to create a table for your imageBase
```
iq.write("Hello, this is a basic text!");
iq.write("Hello, this is a basic text! but there is a given name here!", "TABLE_NAME");
```

to read your TableImages
```
iq.read("TABLE_NAME");
```
