import './App.css';
import Todo from './Todo';
import React from 'react';

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

  render(){

    // js가 제공하는 map 함수를 이용해 배열을 반복해 <Todo /> 컴포넌트 생성
    var todoItems = this.state.items.map((item, idx)=>(
      <Todo item={item} key={item.id} />
    ));
    
    // 생성된 컴포넌트 리턴
    return <div className="App">{todoItems}</div>;

  }
}

export default App;
