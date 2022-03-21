import './App.css';
import Todo from './Todo';
import React from 'react';
import { Paper, List, Container } from "@material-ui/core";
import AddTodo from './AddTodo';

class App extends React.Component{
  constructor(props){
    super(props);
    // item -> items
    this.state={
      items: [{id: 0, title: "Hello World 1", done: true},                
              {id: 1, title: "Hello World 2", done: false},
             ],
    };
  }

  add = (item) => {
    const thisItems = this.state.items;
    item.id = 'ID-' + this.state.items.length; // key를 위한 ID 추가
    item.done = false; // done 초기화
    thisItems.push(item); // 리스트에 아이템 추가
    this.setState(thisItems); // 업데이트
    console.log("item: ", this.state.items)
  }

  render(){
    var todoItems = this.state.items.length > 0 && (
    <Paper style={{ margin: 16 }}>    
      <List>
        {this.state.items.map((item, idx) => (
          <Todo item={item} key={item.id} />
        ))}
      </List>
    </Paper>
    );
    // 생성된 컴포넌트 리턴
    return <div className="App">
              <Container maxWidth="md">
                <AddTodo add={this.add}/>
                <div className="TodoList">{todoItems}</div>
              </Container>
            </div>;
  }
}

export default App;
