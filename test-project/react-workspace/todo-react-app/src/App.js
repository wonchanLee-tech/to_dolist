import './App.css';
import Todo from './Todo';
import React from 'react';
import { Paper, List, Container, Typography } from "@material-ui/core";
import AddTodo from './AddTodo';
import {call, signout} from './ApiService';
import {AppBar, Toolbar, Grid, Button} from '@material-ui/core';

class App extends React.Component{
  constructor(props){
    super(props);
    // item -> items
    this.state={
      items: [],
      // 로딩 상태
      loading: true,
    };
  }

  componentDidMount() {
    call("/todo", "GET", null).then((response) => 
       this.setState({items: response.data, loading: false})
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

    // navigatorBar 추가
    var navigationBar = (
      <AppBar position="static">
        <Toolbar>
          <Grid justify="space-between" container>
            <Grid item>
              <Typography variant="h6">오늘의 할 일</Typography>
            </Grid>
            <Grid item>
              <Button color="inherit" onClick={signout}>
                로그아웃
              </Button>
            </Grid>
          </Grid>
        </Toolbar>
      </AppBar>
    );

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
    
    var todoListPage = (
            <div>
              {navigationBar} {/* 네비게이션 바 렌더링*/}
              <Container maxWidth="md">
                <AddTodo add={this.add}/>
                <div className="TodoList">{todoItems}</div>
              </Container>
            </div>
    );
    
    // 로딩 페이지
    var loadingPage = <h1> 로딩중.. </h1>;

    /*loading중이면, loading page를 content로*/
    var content = loadingPage;
    if(!this.state.loading) content = todoListPage;

    return <div className="App">{content}</div>;
  }
}

export default App;
