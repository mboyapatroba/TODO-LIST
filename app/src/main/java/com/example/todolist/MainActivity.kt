package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter : TodoAdapter
    lateinit var todo_items: RecyclerView
    lateinit var todo_titles: EditText
    lateinit var add_todo: Button
    lateinit var delete_todo: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        todo_items=findViewById(R.id.rvTodoItems)
        todo_titles=findViewById(R.id.etTodoTitle)
        add_todo=findViewById(R.id.btnAddTodo)
        delete_todo=findViewById(R.id.btnDeleteDoneTodo)

        todo_items.adapter = todoAdapter
        todo_items.layoutManager = LinearLayoutManager(this)

        add_todo.setOnClickListener {
            val todoTitle = todo_titles.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                todo_titles.text.clear()
            }
        }
        delete_todo.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}