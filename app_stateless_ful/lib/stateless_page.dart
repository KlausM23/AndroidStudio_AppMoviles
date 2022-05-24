import 'package:flutter/material.dart';

class StatelessApp extends StatelessWidget {
  StatelessApp({Key? key}) : super(key: key);

  int counter = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Ejemplo de stateless widget"),
        ),
        body: Center(
            child: Text("counter " + counter.toString())
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.plus_one),
          onPressed: () {
            counter++;
            print(counter);
          },
        ),
      ),
    );
  }
}