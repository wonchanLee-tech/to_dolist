import React from "react";
import "./index.css";
import App from "./App";
import Login from "./Login";
import SignUp from "./SignUp";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";

function Copyright(){
    return(
        <Typography variant="body2" color="textSecondary" align="center">
            {"Copyright ⓒ "}
            wonchanLee, {new Date().getFullYear()}
            {"."}
        </Typography>
    );
}

class AppRouter extends React.Component{
    render(){
        return(
            <div>
                <Router>
                        <Routes>
                            <Route path="/login" element={<Login/>}/>
                            <Route path="/signup" element={<SignUp/>}/>
                            <Route path="/" element={<App/>}/>
                        </Routes>
                    <Box mt={5}>
                        <Copyright/>
                    </Box>
                </Router>
            </div>
        );
    }
}

export default AppRouter;