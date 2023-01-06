import { useAuth0 } from "@auth0/auth0-react";
import React from "react";
import { useLocation } from "react-router-dom";
import { Navigate } from "react-router-dom";
import { useNavigate } from 'react-router-dom';


const LoginButton :React.FC = () => {
    const navigate = useNavigate();
    const {loginWithRedirect, logout, isAuthenticated, user} = useAuth0();
    if(!isAuthenticated){
        return (
            <button onClick={() => loginWithRedirect()}>
                Prijava
            </button>
        )
    }else{
        return (
            <div>
            <button onClick={() => navigate('/profile')}>
                Korisnički profil
            </button>
            <button onClick={async() => fetch("http://localhost:5000")}>
                Osvježi preslike
            </button>
            <button onClick={() => logout()}>
                Odjava
            </button>
            </div>
        )
    }
}
export default LoginButton