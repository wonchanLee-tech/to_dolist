import './App.css';
import Todo from './Todo';
import React from 'react';
import { Paper, List, Container } from "@material-ui/core";
import AddTodo from './AddTodo';
import {call} from './ApiService';

class App extends React.Component{
  constructor(props){
    super(props);
    // item -> items
    this.state={
      items: [],
    };
  }

  componentDidMount() {
    call("/todo", "GET", null).then((response) => 
       this.setState({items: response.data})
    );
  }

  add = (item) => {
    call("/todo", "POST", item).then((response) => 
      this.setState({items: response.data})
    );
  };

  delete = (item) => {
    call("/todo", "DELETE", item).then((response) =>
      this.setState({items: response.data})
    );
  };

  update = (item) => {
    call("/todo", "PUT", item).then((response) =>
      this.setState({items: response.data})
    );
  }

  render(){
    var todoItems = this.state.items.length > 0 && (
    <Paper style={{ margin: 16 }}>    
      <List>
        {this.state.items.map((item, idx) => (
          <Todo item={item} 
                key={item.id} 
                delete={this.delete}
                update={this.update}      
          />
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
