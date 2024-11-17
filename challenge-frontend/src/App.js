import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ChallengeList from './ChallengeList';
import EncourageList from './EncourageList';
import FinishChallenge from './FinishChallenge';
import ChallengeHistory from './ChallengeHistory';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<ChallengeList />} />
                <Route path="/encourage" element={<EncourageList />} />
                <Route path="/finish" element={<FinishChallenge />} />
                <Route path="/history" element={<ChallengeHistory />} />
            </Routes>
        </Router>
    );
}

export default App;
