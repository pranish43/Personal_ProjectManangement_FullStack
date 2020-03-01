import React, { Component } from 'react';
import ProjectItem from './Project/ProjectItem';
import Header from './Layout/Header';

class Dashboard extends Component {
    render() {
        return (
          <div>
          <Header /> 
          
           <div className="projects">
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <h1 className="display-4 text center">Projects</h1>
                            <br/>
                            <hr/>
                            <div className="container">
                                <div className="card card-body bg-light mb-3">
                                    <div className="row">
                                        <div className="col-2">
                                            <span className="mx-auto">React</span>
                                        </div>
                                        <div className="col-lg-6 col-md-4 col-8">
                                            <h3>Spring / React Project</h3>
                                            <p>This t</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
           </div>
        </div>
        );
    }
}

export default Dashboard;