import { useAuth0 } from "@auth0/auth0-react";
import React from "react";
import { useLocation } from "react-router-dom";
import { useNavigate } from 'react-router-dom';

const Profile :React.FC = () => {
    const navigate = useNavigate();
    const {isAuthenticated, user} = useAuth0();
    if(!isAuthenticated){
        return (
            <button >
                Prijava
            </button>
        )
    }else{
        return (<div>
            <article className='column'>
                {user?.picture && <img src={user.picture} alt={user?.name}/>}
               <h2>{user?.name}</h2> 
               {JSON.stringify(user)}
               
            </article>

            <button onClick={() => navigate('/')}>
                Natrag
            </button>
            </div>
        )
    }
}
export default Profile