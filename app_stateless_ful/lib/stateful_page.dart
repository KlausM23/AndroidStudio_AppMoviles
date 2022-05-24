import 'package:flutter/material.dart';

class StatefulApp extends StatefulWidget {
  const StatefulApp({Key? key}) : super(key: key);

  @override
  State<StatefulApp> createState() => _MyStatelessAppState();
}

class _MyStatelessAppState extends State<StatefulApp> {
  int counter = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Ejemplo de stateless widget"),
        ),
        body: Center(
            child: Text(
          "counter: " + counter.toString(),
          style: TextStyle(fontSize: 40),
        )),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.plus_one),
          onPressed: () {
            counter++;
            setState(() {});
            print(counter);
          },
        ),
      ),
    );
  }
}
