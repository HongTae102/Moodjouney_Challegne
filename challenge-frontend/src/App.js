import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ChallengeList from './ChallengeList';
import FinishChallenge from './FinishChallenge';
import ChallengeHistory from './ChallengeHistory';
import Register from './Register';
import Login from "./login";
import Membership from "./Membership";

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Register />} />
                <Route path="/register" element={<Register />} />
                <Route path="/challenge" element={<ChallengeList />} />
                <Route path="/finish" element={<FinishChallenge />} />
                <Route path="/history" element={<ChallengeHistory />} />
                <Route path="/login" element={<Login />} />
                <Route path="/membership" element={<Membership />} />
            </Routes>
        </Router>
    );
}

export default App;
